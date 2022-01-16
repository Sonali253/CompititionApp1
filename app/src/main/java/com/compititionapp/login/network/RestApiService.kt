package com.compititionapp.login.network

import android.util.Log
import com.compititionapp.model.UserInfo
import com.compititionapp.retrofit.RestApi
import com.compititionapp.retrofit.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestApiService {
    val TAG = RestApiService::class.java.getName()

    fun login(userData: UserInfo) : String? { // , onResult: (UserInfo?) -> Unit
        Log.d(TAG, "login- $userData")
        val result = LoginData.Result()
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.doLogin(userData).enqueue(
            object : Callback<LoginData> {
                override fun onFailure(call: Call<LoginData>, t: Throwable) {
                    Log.d(TAG,"Throwable- "+t.message)
                    //onResult(null)
                }
                override fun onResponse(call: Call<LoginData>, response: Response<LoginData>) {
                    val addedUser = response.body()
                    Log.d(TAG,addedUser.toString())
                    if(addedUser?.getStatus().equals("SUCCESS")){
                        result.getResourceId()
                        result.getMobileNo()

                    }
                    //onResult(addedUser)
                }
            }
        )
        return result.getResourceId()
    }

    fun addUser(userData: UserInfo){ // , onResult: (UserInfo?) -> Unit
        Log.d("@", "addUser- $userData")
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.doRegistration(userData).enqueue(
            object : Callback<LoginData> {
                override fun onFailure(call: Call<LoginData>, t: Throwable) {
                    Log.d(TAG,"Throwable- "+t.message)
                    //onResult(null)
                }
                override fun onResponse(call: Call<LoginData>, response: Response<LoginData>) {
                    val addedUser = response.body()
                    Log.d(TAG,"Response"+addedUser.toString())

                    //onResult(addedUser)
                }
            }
        )
    }


}