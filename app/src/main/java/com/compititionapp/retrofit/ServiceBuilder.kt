package com.compititionapp.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ServiceBuilder {

    private val client = OkHttpClient.Builder().build()

    private var retrofit = Retrofit.Builder()
        .baseUrl("http://3.108.247.204:8088/") // local ip- 192.168.2.6 change this IP for testing by your actual machine IP
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()


    fun<T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }
}