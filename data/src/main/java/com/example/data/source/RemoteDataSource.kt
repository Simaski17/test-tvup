package com.example.data.source

import com.example.domain.Backgrounds

interface RemoteDataSource {

    suspend fun getListFeed(): List<Backgrounds>

}