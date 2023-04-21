package com.example.apicalling

import com.example.apicalling.model.Data
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {
    @GET("https://midasfurniture.com/rest/V1/configurationdata?deviceType=Android&languageData=en&storeId=1&deviceId=2050d672e1d9538e&deviceToken=cR")
    suspend fun getAll(): Response<Data>


}