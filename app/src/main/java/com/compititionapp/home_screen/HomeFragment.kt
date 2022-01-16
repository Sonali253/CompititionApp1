package com.compititionapp.home_screen

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.compititionapp.R
import com.compititionapp.Util.PrefManager
import com.compititionapp.Util.Utils
import com.compititionapp.model.studymaterialAPI.GetStudyMaterial
import com.compititionapp.personlize.PersonlizeActivity
import com.compititionapp.retrofit.RestApi
import com.compititionapp.retrofit.ServiceBuilder
import com.compititionapp.workbook.WorkbookActivity
import com.compititionapp.workbook.adapter.WorkbookAdapter
import com.compititionapp.workbook.adapter.WorkbookModel
import kotlinx.android.synthetic.main.workbook_recyclerview.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {

    val TAG = HomeFragment::class.java.name
    lateinit var rootView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_home, container, false)
        val imageView = rootView.findViewById<ImageView>(R.id.imageView_filter)
        val textWorkbook = rootView.findViewById<TextView>(R.id.workbook)
        val recyclerView = rootView.findViewById<RecyclerView>(R.id.recyclerView)
        val textNoData = rootView.findViewById<TextView>(R.id.text_no_data)
        val mockCard = rootView.findViewById<CardView>(R.id.mock_card_view)
        val onlineCard = rootView.findViewById<CardView>(R.id.online_card_view)

        //val strtext = arguments!!.getSerializable("subjectList")
        if(arguments?.getSerializable("subjectList") != null) {
            val courseModelArrayList: ArrayList<WorkbookModel> =
                arguments?.getSerializable("subjectList") as ArrayList<WorkbookModel>
            Log.e("StudyMaterial", "subjectList- $courseModelArrayList")
            if (!courseModelArrayList.isEmpty()){
                textNoData.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE
                initialiseAdapter(courseModelArrayList)
            }

            else {
                textNoData.visibility = View.VISIBLE
                recyclerView.visibility = View.GONE
            }
        }

        showSubjectSpinner()

        textWorkbook.setOnClickListener {
            val intent = Intent(context, WorkbookActivity::class.java)
            //intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
        imageView.setOnClickListener {
            val intent = Intent(context, PersonlizeActivity::class.java)
            //intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
        mockCard.setOnClickListener{
            val intent = Intent(context, MockOrOnlineActivity::class.java)
            intent.putExtra("testType","MOCK")
            //intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            // getAllMockOrOnlineTestData("MOCK")
        }
        onlineCard.setOnClickListener{
            //getAllMockOrOnlineTestData("ONLINE")
            val intent = Intent(context, MockOrOnlineActivity::class.java)
            intent.putExtra("testType","ONLINE")
            startActivity(intent)
        }
        return rootView
    }

    private fun initialiseAdapter(courseModelArrayList: ArrayList<WorkbookModel>) {
        // we are initializing our adapter class and passing our arraylist to it.
        val firstFiveItemsList = ArrayList<WorkbookModel>()
        val workbookAdapter = WorkbookAdapter()

        if(courseModelArrayList.size >= 6) {
            for (i in 0..5) {
                firstFiveItemsList.add(courseModelArrayList.get(i))
            }
            workbookAdapter.firstFiveItemsList = firstFiveItemsList
        }

        var gridlayoutManager : GridLayoutManager
        gridlayoutManager = GridLayoutManager(context,3)

        workbookAdapter.context = context
        workbookAdapter.workbookModelList = courseModelArrayList

        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = workbookAdapter
        recyclerView.layoutManager = gridlayoutManager
    }

    fun showSubjectSpinner() { // custom dialog
        var flag:Int = 0
        var subjects : ArrayList<String> = ArrayList()
        var prefManager = PrefManager()
        prefManager.context = activity

        var choices = Utils.loadJsonFromLocal(context)

        val spinner: Spinner = rootView.findViewById<Spinner>(R.id.dropdown_subject)
        //val languages = resources.getStringArray(R.array.Subjects)

        for (i in choices.getSubjectList()!!.indices){
            subjects.add(choices.getSubjectList()!!.get(i)!!.getName()!!)
        }
        if (spinner != null) {
            val adapter = ArrayAdapter(requireContext(),
                R.layout.spinner_item, subjects)

            spinner.adapter = adapter
            for (i in subjects.indices){
                if(choices.getSubjectList()!!.get(i)!!.getCode().equals(prefManager.getString("chipSelectedSubject")))
                    spinner.setSelection(i)
            }

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    // if(++flag > 1) {
                    spinner.setSelection(position)
                    prefManager.putString("chipSelectedSubject", choices.getSubjectList()!![position]!!.getCode())

                    val state: String? = prefManager.getString("chipSelectedState")
                    val pattern: String? = prefManager.getString("chipSelectedPattern")
                    val competition: String? = prefManager.getString("chipSelectedCompitition")
                    val standard: String? = prefManager.getString("chipSelectedStandard")
                    val subject: String? = prefManager.getString("chipSelectedSubject")

                    Log.e("spinner STORED VALUE\n", "" + state + pattern + competition + standard + subject)
                    getStudyMaterial(state!!, pattern!!, competition!!, standard!!, subject!!, "0", "10")
                    //getDataFromLocal(subject!!)

                    //}
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
    }

    private fun getStudyMaterial(states: String,pattern: String,competitionType: String,standard: String,subjects: String,page: String,size: String){ // , onResult: (UserInfo?) -> Unit
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.getStudyMaterials(states, pattern, competitionType, standard, subjects, page, size).enqueue(
            object : Callback<GetStudyMaterial> {
                override fun onFailure(call: Call<GetStudyMaterial>, t: Throwable) {
                    Log.d(TAG,"Throwable- "+t.message)
                    //onResult(null)
                }
                override fun onResponse(call: Call<GetStudyMaterial>, response: Response<GetStudyMaterial>) {
                    val addedUser = response.body()
                    Log.d(TAG,"@Response- "+addedUser.toString())
                    var courseModelArrayList: ArrayList<WorkbookModel> = ArrayList()
                    if(addedUser!= null){
                        if(addedUser.getStatus().equals("success")){
                            val totalStudyMaterialList = addedUser.getTotalStudyMaterialCount()
                            for(i in totalStudyMaterialList!!.indices){
                                Log.e("totalStudyMaterialList","ImgUrl- "+totalStudyMaterialList.get(i)!!.getSmImgUrl())
                                val workbook :WorkbookModel = WorkbookModel()
                                workbook.setId(i)
                                workbook.setSubject_image(totalStudyMaterialList.get(i)!!.getSmImgUrl()!!)
                                workbook.setSubject_name(totalStudyMaterialList.get(i)!!.getSmName()!!)

                                courseModelArrayList.add(workbook)
                                Log.e("courseModelArrayList", "Adapter- $courseModelArrayList")
                                initialiseAdapter(courseModelArrayList)

                            }
                        }
                    }
                    //onResult(addedUser)
                }
            }
        )
    }


}
