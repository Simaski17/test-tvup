package com.example.data.repository

import com.example.data.source.LocalDataSource
import com.example.data.source.RemoteDataSource

class BackgroundsRepository (private val localDataSource: LocalDataSource, private val remoteDataSource: RemoteDataSource)  {

    suspend fun getListBackgrounds(): List<String> {
        var backs = remoteDataSource.getListFeed()
        localDataSource.saveListBackgrounds((backs as List<String>?)!!)
        return backs
    }

}