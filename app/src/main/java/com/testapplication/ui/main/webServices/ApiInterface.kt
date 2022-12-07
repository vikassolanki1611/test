package com.example.post_api
import com.testapplication.ui.main.dataClass.testData
import retrofit2.Call
import retrofit2.http.*


public interface ApiInterface {

    @GET("posts")
    fun getData(): Call<testData>


    }



