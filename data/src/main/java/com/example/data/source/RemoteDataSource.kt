package com.example.data.source

import com.example.domain.Backgrounds
import com.example.domain.ResponseIMDB

interface RemoteDataSource {

    suspend fun getListFeed(): List<Backgrounds>
    suspend fun getListMovies(): List<ResponseIMDB>

}