package com.compititionapp.home_screen


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
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
import kotlinx.android.synthetic.main.activity_home_screen.*
import kotlinx.android.synthetic.main.workbook_recyclerview.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeScreenActivity : AppCompatActivity() {

    val TAG = HomeScreenActivity::class.java.getName()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        val firstFragment=HomeFragment()
        val secondFragment=ProfileFragment()

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home->setCurrentFragment(firstFragment)
                R.id.profile->setCurrentFragment(secondFragment)
            }
            true
        }

        setCurrentFragment(firstFragment)
    }
    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }

    override fun onBackPressed() {
        finish()
    }

    /*private fun getDataFromLocal(subjects: String) {
        var addedUser = GetStudyMaterial()
        var textNoData = findViewById<TextView>(R.id.text_no_data)
        val layout_adapter_view = findViewById<LinearLayout>(R.id.include2)

        textNoData.visibility = View.GONE
        if(subjects.equals("math"))  {
            layout_adapter_view.visibility = View.VISIBLE
            addedUser = Utils.loadMathSubjectJson(this)
        }
        else if(subjects.equals("sci")) {
            layout_adapter_view.visibility = View.VISIBLE
            addedUser = Utils.loadSciSubjectJson(this)
        }
        else {
            textNoData.visibility = View.VISIBLE
            layout_adapter_view.visibility = View.GONE
        }

        var courseModelArrayList: ArrayList<WorkbookModel> = ArrayList()
        if(addedUser!= null){
            if(addedUser.getStatus().equals("success")){
                val totalStudyMaterialList = addedUser.getTotalStudyMaterialCount()
                for(i in totalStudyMaterialList!!.indices){
                    Log.e("totalStudyMaterialList","ImgUrl- "+totalStudyMaterialList.get(i)!!.getSmImgUrl())
                    val workbook :WorkbookModel = WorkbookModel()

                    workbook.setSubject_image(totalStudyMaterialList.get(i)!!.getSmImgUrl()!!)
                    workbook.setSubject_name(totalStudyMaterialList.get(i)!!.getSmName()!!)

                    courseModelArrayList.add(workbook)
                    Log.e("courseModelArrayList", "Adapter- $courseModelArrayList")
                    initialiseAdapter(courseModelArrayList)

                }
            }
        }
    }*/

}


