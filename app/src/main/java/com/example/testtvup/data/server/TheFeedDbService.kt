package com.example.testtvup.data.server

import retrofit2.Call
import retrofit2.http.GET

interface TheFeedDbService {

    @GET("backgrounds.json")
    fun getListFeed(): Call<List<String>>

}