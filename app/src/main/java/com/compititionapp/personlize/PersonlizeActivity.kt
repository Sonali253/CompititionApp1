package com.compititionapp.personlize


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.compititionapp.R
import com.compititionapp.Util.PrefManager
import com.compititionapp.Util.Utils
import com.compititionapp.home_screen.HomeFragment
import com.compititionapp.home_screen.HomeScreenActivity
import com.compititionapp.model.studymaterialAPI.GetStudyMaterial
import com.compititionapp.retrofit.RestApi
import com.compititionapp.retrofit.ServiceBuilder
import com.compititionapp.workbook.adapter.WorkbookModel
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PersonlizeActivity : AppCompatActivity() {

    private var booleanArrayList: ArrayList<Boolean> = ArrayList()
    private lateinit var chipGroupState: ChipGroup
    private var prefManager: PrefManager = PrefManager()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personlize)
        val submit = findViewById<Button>(R.id.button)
        val chipGroupSubject = findViewById<ChipGroup>(R.id.chip_group_subject)
        val chipGroupStandard = findViewById<ChipGroup>(R.id.chip_group_standard)
        val chipGroupCompitition = findViewById<ChipGroup>(R.id.chip_group_compitition)
        val chipGroupPattern = findViewById<ChipGroup>(R.id.chip_group_pattern)
        chipGroupState = findViewById<ChipGroup>(R.id.chip_group_state)
        prefManager.context = this

        /*for (i in 0..4) {
            val chip = Chip(this)
            chip.id = i
            chip.tag = i
            booleanArrayList.add(false)
            chip.text = "Chip No : $i"
            chip.isCheckable = true

            if(chip.text == prefManager.getString("chipSelected"))
                chip.isChecked = true
            chip.setOnCheckedChangeListener { compoundButton, b ->
                val tag = compoundButton.tag as Int
                booleanArrayList[tag] = b
            }
            chipGroupState.addView(chip)
        }
        chipGroupState.invalidate()

        chipGroupState.setOnCheckedChangeListener { group, i ->
            val chip: Chip = group.findViewById(i)
            if (chip != null)
                Toast.makeText(getApplicationContext(), "Chip is " + chip.getText().toString(), Toast.LENGTH_SHORT).show();

            prefManager.putString("chipSelected",chip.getText().toString())
            Log.e("prefManager", "chipSelected- "+prefManager.getString("chipSelected"));
            Log.e("OnCheckedChangeListener", "Called");

        }
        val onCheckedChangeListener =
            ChipGroup.OnCheckedChangeListener { chipGroup, i ->

            }
*/
        var choices = Utils.loadJsonFromLocal(this)

        getListOfState(chipGroupState, choices)
        getListOfStandard(chipGroupStandard, choices)
        getListOfSubject(chipGroupSubject, choices)
        getListOfCompitition(chipGroupCompitition, choices)
        getListOfPattern(chipGroupPattern, choices)


        submit.setOnClickListener {

            //apiService.getAllTest("0","10")
            val state: String? =  prefManager.getString("chipSelectedState")
            val pattern: String? =  prefManager.getString("chipSelectedPattern")
            val competition: String? =  prefManager.getString("chipSelectedCompitition")
            val standard: String? =  prefManager.getString("chipSelectedStandard")
            val subject: String? =  prefManager.getString("chipSelectedSubject")

            Log.e("submit STORED VALUE\n",""+state+pattern+competition+standard+subject)

            //getDataFromLocal(subject!!)
            getStudyMaterial(state!!, pattern!!, competition!!, standard!!, subject!!, "0", "10")

            /*val intent = Intent(this, HomeScreenActivity::class.java)
            intent.putExtra("subjectList",subjectList)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)*/
        }

    }

    /*private fun getDataFromLocal(subjects: String) {
        var addedUser = GetStudyMaterial()
        var courseModelArrayList: ArrayList<WorkbookModel> = ArrayList()
        //var textNoData = findViewById<TextView>(R.id.text_no_data)
        //val layout_adapter_view = findViewById<LinearLayout>(R.id.include2)


        if(subjects.equals("math"))  {

            addedUser = Utils.loadMathSubjectJson(this)
        }
        else if(subjects.equals("sci")) {

            addedUser = Utils.loadSciSubjectJson(this)
        }
        else {
            //textNoData.visibility = View.VISIBLE
            //layout_adapter_view.visibility = View.GONE

        }


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

                }
                Log.e("StudyMaterial", "subjectList- $courseModelArrayList")

            }
        }

        val intent = Intent(this@PersonlizeActivity, HomeScreenActivity::class.java)
        intent.putExtra("subjectList",courseModelArrayList)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }*/

    private fun getStudyMaterial(states: String,pattern: String,competitionType: String,standard: String,subjects: String,page: String,size: String){ // , onResult: (UserInfo?) -> Unit
        Log.d("@", "page- $page")
        Log.d("@", "size- $size")
        //Log.d("STORED VALUE\n",""+states+pattern+competitionType+standard+subjects)
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.getStudyMaterials(states, pattern, competitionType, standard, subjects, page, size).enqueue(
            object : Callback<GetStudyMaterial> {
                override fun onFailure(call: Call<GetStudyMaterial>, t: Throwable) {
                    Log.d("@","Throwable- "+t.message)
                    //onResult(null)
                    val intent = Intent(this@PersonlizeActivity, HomeScreenActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    val bundle = Bundle()
                    val fragobj = HomeFragment()
                    fragobj.arguments = bundle
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

                            }
                            Log.e("StudyMaterial", "subjectList- $courseModelArrayList")
                            val intent = Intent(this@PersonlizeActivity, HomeScreenActivity::class.java)
                            intent.putExtra("subjectList",courseModelArrayList)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(intent)
                            val bundle = Bundle()
                            bundle.putSerializable("subjectList", courseModelArrayList)
                            // set Fragmentclass Arguments
                            val fragobj = HomeFragment()
                            fragobj.arguments = bundle
                        }
                    }else {
                        Toast.makeText(this@PersonlizeActivity, "No data found", Toast.LENGTH_SHORT)
                            .show()
                        val intent = Intent(this@PersonlizeActivity, HomeScreenActivity::class.java)
                        intent.putExtra("subjectList",courseModelArrayList)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                        val bundle = Bundle()
                        bundle.putSerializable("subjectList", courseModelArrayList)
                        // set Fragmentclass Arguments
                        val fragobj = HomeFragment()
                        fragobj.arguments = bundle
                    }
                    //onResult(addedUser)
                }
            }
        )
    }

    private fun getListOfCompitition(chipGroupCompitition: ChipGroup, choices: CustomObjectChoices) {
        val competitionList = choices.getCompetitionList()
        for (i in competitionList?.indices!!) {

            val chip = layoutInflater.inflate(R.layout.chip_choice_subject, null) as Chip
            //val chip = Chip(this)
            chip.id = i
            chip.tag = i
            booleanArrayList.add(false)
            chip.text = competitionList.get(i)!!.getName()
            chip.isCheckable = true

            if (competitionList.get(i)!!.getCode() == prefManager.getString("chipSelectedCompitition"))
                chip.isChecked = true
            chip.setOnCheckedChangeListener { compoundButton, b ->
                val tag = compoundButton.tag as Int
                booleanArrayList[tag] = b
            }
            chipGroupCompitition.addView(chip)
        }
        chipGroupCompitition.invalidate()

        chipGroupCompitition.setOnCheckedChangeListener { group, i ->
            val chip: Chip = group.findViewById(i)

            prefManager.putString("chipSelectedCompitition", competitionList.get(i)?.getCode())

        }
    }

    private fun getListOfPattern(chipGroupPattern: ChipGroup, choices: CustomObjectChoices) {
        val patternList = choices.getBoardList()

        for (i in patternList?.indices!!) {

            Log.i("Compitition", "> Item $patternList")
            val chip = layoutInflater.inflate(R.layout.chip_choice_subject, null) as Chip
            //val chip = Chip(this)
            chip.id = i
            chip.tag = i
            booleanArrayList.add(false)
            chip.text = patternList.get(i)?.getName()
            chip.isCheckable = true

            if (patternList.get(i)!!.getCode() == prefManager.getString("chipSelectedPattern"))
                chip.isChecked = true
            chip.setOnCheckedChangeListener { compoundButton, b ->
                val tag = compoundButton.tag as Int
                booleanArrayList[tag] = b
            }
            chipGroupPattern.addView(chip)
        }
        chipGroupPattern.invalidate()

        chipGroupPattern.setOnCheckedChangeListener { group, i ->
            val chip: Chip = group.findViewById(i)
            prefManager.putString("chipSelectedPattern", patternList.get(i)!!.getCode())
        }

    }

    /*override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy","Called")
        //prefManager.clear("ChipSelected")
    }*/

    private fun getListOfState(chipGroupState: ChipGroup, choices: CustomObjectChoices) {
        val stateList = choices.getStateList()

        for (i in stateList?.indices!!) {
            val chip = layoutInflater.inflate(R.layout.chip_choice_subject, null) as Chip
            //val chip = Chip(this)
            chip.id = i
            chip.tag = i
            booleanArrayList.add(false)
            chip.text = stateList.get(i)!!.getName()
            chip.isCheckable = true

            if (stateList.get(i)!!.getCode() == prefManager.getString("chipSelectedState"))
                chip.isChecked = true
            chip.setOnCheckedChangeListener { compoundButton, b ->
                val tag = compoundButton.tag as Int
                booleanArrayList[tag] = b
            }
            chipGroupState.addView(chip)
        }
        chipGroupState.invalidate()

        chipGroupState.setOnCheckedChangeListener { group, i ->
            val chip: Chip = group.findViewById(i)
            prefManager.putString("chipSelectedState", stateList.get(i)!!.getCode())
        }

    }

    private fun getListOfStandard(chipGroupStandard: ChipGroup, choices: CustomObjectChoices) {
        val standardList = choices.getStanderdList()

        for (i in standardList?.indices!!) {
            val chip = layoutInflater.inflate(R.layout.chip_choice_subject, null) as Chip
            //val chip = Chip(this)
            chip.id = i
            chip.tag = i
            booleanArrayList.add(false)
            chip.text = standardList.get(i)!!.getName()
            chip.isCheckable = true

            if (standardList.get(i)!!.getCode() == prefManager.getString("chipSelectedStandard"))
                chip.isChecked = true
            chip.setOnCheckedChangeListener { compoundButton, b ->
                val tag = compoundButton.tag as Int
                booleanArrayList[tag] = b
            }
            chipGroupStandard.addView(chip)
        }
        chipGroupStandard.invalidate()

        chipGroupStandard.setOnCheckedChangeListener { group, i ->
            val chip: Chip = group.findViewById(i)

            prefManager.putString("chipSelectedStandard", standardList.get(i)!!.getCode())
        }
    }

    private fun getListOfSubject(chipGroupSubject: ChipGroup, choices: CustomObjectChoices) {
        val subjectList = choices.getSubjectList()

        for (i in subjectList?.indices!!) {
            val chip = layoutInflater.inflate(R.layout.chip_choice_subject, null) as Chip
            //val chip = Chip(this)
            chip.id = i
            chip.tag = i
            booleanArrayList.add(false)
            chip.text = subjectList.get(i)!!.getName()
            chip.isCheckable = true

            if (subjectList.get(i)!!.getCode() == prefManager.getString("chipSelectedSubject"))
                chip.isChecked = true
            chip.setOnCheckedChangeListener { compoundButton, b ->
                val tag = compoundButton.tag as Int
                booleanArrayList[tag] = b
            }
            chipGroupSubject.addView(chip)
        }
        chipGroupSubject.invalidate()

        chipGroupSubject.setOnCheckedChangeListener { group, i ->
            val chip: Chip = group.findViewById(i)

            prefManager.putString("chipSelectedSubject", subjectList.get(i)!!.getCode())
        }
    }
}
