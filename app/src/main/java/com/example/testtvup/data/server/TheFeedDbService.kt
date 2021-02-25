package com.example.testtvup.data.server

import com.example.domain.ResponseIMDB
import retrofit2.Call
import retrofit2.http.GET

interface TheFeedDbService {

    @GET("backgrounds.json")
    fun getListFeed(): Call<List<String>>

    @GET("feed.json")
    fun getListMovies(): Call<List<ResponseIMDB>>

}