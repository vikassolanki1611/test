package com.example.post_api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiHttpCLient {
        private var retrofit: Retrofit? = null
        private var request: Request? = null
        private val mRerofitBuilder: Retrofit.Builder? = null
        private val BASE_URL = "https://jsonplaceholder.typicode.com/"

        public  fun getClient(): Retrofit? {
            val okHttpClient = OkHttpClient.Builder().addInterceptor(ServiceBuilder.headinterceptor)
                .build()
            retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
            return retrofit
        }
    }

