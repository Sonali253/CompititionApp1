package com.compititionapp.retrofit

import com.compititionapp.home_screen.model.MockOrOnlineTest
import com.compititionapp.login.network.LoginData
import com.compititionapp.model.UserInfo
import com.compititionapp.model.studymaterialAPI.GetStudyMaterial
import com.compititionapp.personlize.network.Example
import retrofit2.Call
import retrofit2.http.*


interface RestApi {
    @Headers("Content-Type: application/json")
    @POST("api/login")
    fun doLogin(@Body userData: UserInfo): Call<LoginData>

    @Headers("Content-Type: application/json")
    @POST("api/save-resource")
    fun doRegistration(@Body userData: UserInfo): Call<LoginData>

    @GET("test/all-test")
    fun getAllTest(@Query("page") page: String?, @Query("size") size: String): Call<Example>

    @GET("studymaterial/allStudyMaterial")
    fun getStudyMaterials(@Query("states")states: String?,@Query("pattern")pattern: String?,@Query("competitionType")competitionType: String?,@Query("standard")standard: String?,@Query("subjects")subjects: String?,@Query("page") page: String?, @Query("size") size: String): Call<GetStudyMaterial>

    @GET("test/get-all-tests")//
    fun getMockOrOnlineTest(@Query("states")states: String?,@Query("pattern")pattern: String?,@Query("competitionType")competitionType: String?,@Query("standard")standard: String?,@Query("subjects")subjects: String?,@Query("testType")testType: String?,@Query("page") page: String?, @Query("size") size: String): Call<MockOrOnlineTest>
//
}