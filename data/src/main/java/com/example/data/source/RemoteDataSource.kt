package com.example.data.source

interface RemoteDataSource {

    suspend fun getListFeed(): List<String>

}