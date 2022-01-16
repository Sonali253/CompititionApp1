package com.compititionapp.personlize.network

import android.util.Log
import com.compititionapp.model.studymaterialAPI.GetStudyMaterial
import com.compititionapp.retrofit.RestApi
import com.compititionapp.retrofit.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestApiService {
    var imgUrlList1 = ArrayList<String> ()

    fun getAllTest(page: String,size: String){ // , onResult: (UserInfo?) -> Unit
        Log.d("@", "page- $page")
        Log.d("@", "size- $size")
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.getAllTest(page, size).enqueue(
            object : Callback<Example> {
                override fun onFailure(call: Call<Example>, t: Throwable) {
                    Log.d("@","Throwable- "+t.message)
                    //onResult(null)
                }
                override fun onResponse(call: Call<Example>, response: Response<Example>) {
                    val addedUser = response.body()
                    Log.d("@Response- ",addedUser.toString())

                    //onResult(addedUser)
                }
            }
        )
    }

}