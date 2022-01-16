package com.compititionapp.home_screen



import android.app.ActionBar
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar.DISPLAY_SHOW_CUSTOM
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.compititionapp.R
import com.compititionapp.Util.PrefManager
import com.compititionapp.home_screen.mock_test.MockModel
import com.compititionapp.home_screen.mock_test.MockTestAdapter
import com.compititionapp.home_screen.model.MockOrOnlineTest
import com.compititionapp.home_screen.model.TestList
import com.compititionapp.home_screen.online_test.OnlineModel
import com.compititionapp.home_screen.online_test.OnlineTestAdapter
import com.compititionapp.retrofit.RestApi
import com.compititionapp.retrofit.ServiceBuilder
import kotlinx.android.synthetic.main.activity_mock_or_online.*
import kotlinx.android.synthetic.main.workbook_recyclerview.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MockOrOnlineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mock_or_online)

        supportActionBar!!.displayOptions = DISPLAY_SHOW_CUSTOM
        supportActionBar!!.setDisplayShowCustomEnabled(true)
        supportActionBar!!.setCustomView(R.layout.custom_action_bar)

        val view = supportActionBar!!.customView
        val name = view.findViewById<TextView>(R.id.text_get_test)
        val backBtn = view.findViewById<TextView>(R.id.text_back_button)
        backBtn.setOnClickListener {
            onBackPressed()
        }

        var mockORonlineText : TextView = findViewById(R.id.text_get_test)
        val loading = findViewById<ProgressBar>(R.id.loading)
        if(intent.getSerializableExtra("testType") != null) {
            val testType: String =
                intent.getSerializableExtra("testType") as String
            Log.e("MockOrOnlineActivity", "testType- $testType")
            if(testType == "MOCK"){
                name.setText("Mock Test")
                loading.visibility = View.VISIBLE
                supportActionBar?.title = mockORonlineText.text
                getAllMockOrOnlineTestData(testType)
            }else if(testType == "ONLINE"){
                name.setText("Online Test")
                loading.visibility = View.VISIBLE
                supportActionBar?.title = mockORonlineText.text
                getAllMockOrOnlineTestData(testType)
            }
        }
    }

    private fun getAllMockOrOnlineTestData(testType: String){
        val prefManager = PrefManager()
        prefManager.context = this
        val state: String? = prefManager.getString("chipSelectedState")
        val pattern: String? = prefManager.getString("chipSelectedPattern")
        val competitionType: String? = prefManager.getString("chipSelectedCompitition")
        val standard: String? = prefManager.getString("chipSelectedStandard")
        val subjects: String? = prefManager.getString("chipSelectedSubject")
        val textNoData = findViewById<TextView>(R.id.text_no_data)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        Log.e("spinner STORED VALUE\n", "" + state + pattern + competitionType + standard + subjects)

        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.getMockOrOnlineTest(state, pattern, competitionType, standard, subjects,testType, "0", "10").enqueue(
            object : Callback<MockOrOnlineTest> {
                override fun onFailure(call: Call<MockOrOnlineTest>, t: Throwable) {
                    Log.d("@","Throwable- "+t.message)
                }
                override fun onResponse(call: Call<MockOrOnlineTest>, response: Response<MockOrOnlineTest>) {
                    val addedUser = response.body()
                    Log.d("@Response- ",addedUser.toString())
                    if(addedUser!= null) {
                        loading.visibility = View.GONE
                        if (testType == "ONLINE") {
                            val onlineModelList: ArrayList<OnlineModel> = ArrayList()
                            val testList: TestList? = addedUser.getTestList()
                            val model = OnlineModel()
                            Log.i("@", "Total Elements- " + testList!!.getNumberOfElements())
                            //Log.i("@", "" + testList.getContent()?.get(0)?.getTestName())
                            if(testList.getNumberOfElements() != 0) {
                                textNoData.visibility = View.GONE
                                recyclerView.visibility = View.VISIBLE

                                for (i in testList.getContent()!!.indices) {
                                    testList.getContent()?.get(i)?.getTestName()
                                        ?.let { model.setTest_title(it) }
                                    model.setTime(testList.getContent()?.get(i)?.getTotalTimeInMinute().toString())
                                    model.setTest_marks(testList.getContent()?.get(i)?.getTotalMarks().toString())
                                    model.setTest_price(testList.getContent()?.get(i)?.getTestPrice().toString())
                                    model.setQuestion_count("100")
                                    onlineModelList.add(model)
                                }
                                initialiseListAdapter(onlineModelList)
                            }else{
                                textNoData.visibility = View.VISIBLE
                                recyclerView.visibility = View.GONE
                            }
                        }
                        else if(testType == "MOCK"){
                            val mockModelList: ArrayList<MockModel> = ArrayList()
                            val testList: TestList? = addedUser.getTestList()
                            val model = MockModel()
                            Log.i("@", "Total Elements- " + testList!!.getNumberOfElements())
                            //Log.i("@", "" + testList.getContent()?.get(0)?.getTestName())
                            if(testList.getNumberOfElements() != 0) {
                                textNoData.visibility = View.GONE
                                recyclerView.visibility = View.VISIBLE

                                for (i in testList.getContent()!!.indices) {
                                    testList.getContent()?.get(i)?.getTestName()
                                        ?.let { model.setTest_title(it) }
                                    model.setTime(testList.getContent()?.get(i)?.getTotalTimeInMinute().toString())
                                    model.setTest_marks(testList.getContent()?.get(i)?.getTotalMarks().toString())
                                    //model.setTest_price(testList.getContent()?.get(i)?.getTestPrice().toString())
                                    model.setQuestion_count("50")
                                    mockModelList.add(model)
                                }
                                initialiseMockListAdapter(mockModelList)
                            }else{
                                textNoData.visibility = View.VISIBLE
                                recyclerView.visibility = View.GONE
                            }
                        }
                    }

                }
            }
        )
    }

    private fun initialiseListAdapter(onlineModelList: ArrayList<OnlineModel>) {
        val onlineAdapter = OnlineTestAdapter()
        onlineAdapter.context =  this
        onlineAdapter.onlineModelList = onlineModelList
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = onlineAdapter

    }

    private fun initialiseMockListAdapter(mockModelList: ArrayList<MockModel>) {
        val mockAdapter = MockTestAdapter()
        mockAdapter.context =  this
        mockAdapter.mockModelList = mockModelList

        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = mockAdapter
    }


}
