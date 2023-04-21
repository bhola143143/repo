package com.example.apicalling

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Retrofitinstance {

    val baseUrl = "https://midasfurniture.com/rest/V1/"

    fun getInstance(): Retrofit {
        val httpClient = OkHttpClient.Builder()

        val logging = HttpLoggingInterceptor()
// set your desired log level
// set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        httpClient.addInterceptor(logging);

        httpClient.addInterceptor { chain ->
            val request: Request =
                chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer x7ezt0c88acxp6330sh220z3tuo2o5dk").build()
            chain.proceed(request)
        }
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            // we need to add converter factory to
            // convert JSON object to Java object
            .build()
    }


}