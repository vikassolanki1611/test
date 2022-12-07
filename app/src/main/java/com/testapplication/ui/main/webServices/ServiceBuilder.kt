package com.example.post_api

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.nio.file.attribute.AclEntry.newBuilder


object ServiceBuilder {
    val headinterceptor = object :Interceptor{
        override fun intercept(chain: Interceptor.Chain): Response {
            var request= chain.request()
//            request= request.newBuilder()
//                .addHeader("Authorization", Credentials.basic(" PMDaksh","PMDaksh@DSj#120") )
//                .addHeader(("Content-Type"),"application/json")
//                .addHeader(("apiKeyMobile"),"pmdaksh@SDt#")
             //   .build()
            val respones=chain.proceed(request)
            return respones

        }
    }
}