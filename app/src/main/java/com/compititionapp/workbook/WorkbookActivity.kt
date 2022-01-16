package com.compititionapp.workbook

import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.compititionapp.Util.PrefManager
import com.compititionapp.R
import com.compititionapp.workbook.adapter.WorkbookListAdapter
import com.compititionapp.workbook.adapter.WorkbookModel
import com.compititionapp.model.studymaterialAPI.GetStudyMaterial
import com.compititionapp.retrofit.RestApi
import com.compititionapp.retrofit.ServiceBuilder
import kotlinx.android.synthetic.main.workbook_recyclerview.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class WorkbookActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_work_book)
        var prefManager = PrefManager()
        prefManager.context = this

        val state: String? = prefManager.getString("chipSelectedState")
        val pattern: String? = prefManager.getString("chipSelectedPattern")
        val competition: String? = prefManager.getString("chipSelectedCompitition")
        val standard: String? = prefManager.getString("chipSelectedStandard")
        val subject: String? = prefManager.getString("chipSelectedSubject")

        //Log.e("spinner STORED VALUE\n", "" + state + pattern + competition + standard + subject)
        getStudyMaterial(
            state!!,
            pattern!!,
            competition!!,
            standard!!,
            subject!!,
            "0",
            "10")

    }

    private fun getStudyMaterial(states: String,pattern: String,competitionType: String,standard: String,subjects: String,page: String,size: String){ // , onResult: (UserInfo?) -> Unit

        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.getStudyMaterials(states, pattern, competitionType, standard, subjects, page, size).enqueue(
            object : Callback<GetStudyMaterial> {
                override fun onFailure(call: Call<GetStudyMaterial>, t: Throwable) {
                    Log.d("@","Throwable- "+t.message)
                    //onResult(null)
                }
                override fun onResponse(call: Call<GetStudyMaterial>, response: Response<GetStudyMaterial>) {
                    val addedUser = response.body()
                    Log.d("@Response- ",addedUser.toString())
                    var courseModelArrayList: ArrayList<WorkbookModel> = ArrayList()
                    if(addedUser!= null){
                        if(addedUser.getStatus().equals("success")){
                            val totalStudyMaterialList = addedUser.getTotalStudyMaterialCount()
                            for(i in totalStudyMaterialList!!.indices){
                                Log.e("totalStudyMaterialList","ImgUrl- "+totalStudyMaterialList.get(i)!!.getSmImgUrl())
                                val workbook : WorkbookModel = WorkbookModel()

                                workbook.setSubject_image(totalStudyMaterialList.get(i)!!.getSmImgUrl()!!)
                                workbook.setSubject_name(totalStudyMaterialList.get(i)!!.getSmName()!!)

                                courseModelArrayList.add(workbook)
                                Log.e("courseModelArrayList", "Adapter- $courseModelArrayList")
                                    initialiseListAdapter(courseModelArrayList)
                                /*for (j in imageViewList) {
                                    Picasso.get().load(totalStudyMaterialList.get(i)!!.getSmImgUrl()).into(j)
                            }*/
                            }


                        }
                    }
                    //onResult(addedUser)
                }
            }
        )

    }

    private fun initialiseListAdapter(courseModelArrayList: ArrayList<WorkbookModel>) {
        val workbookAdapter = WorkbookListAdapter()
        workbookAdapter.context =  this
        workbookAdapter.workbookModelList = courseModelArrayList

        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.setLayoutManager(linearLayoutManager)
        recyclerView.setAdapter(workbookAdapter)

    }
}

