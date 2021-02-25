package com.example.data.repository

import com.example.data.source.LocalDataSource
import com.example.data.source.RemoteDataSource
import com.example.domain.Backgrounds

class BackgroundsRepository (private val localDataSource: LocalDataSource, private val remoteDataSource: RemoteDataSource)  {

    suspend fun getListBackgrounds(): List<Backgrounds> {
        var backs = remoteDataSource.getListFeed()
        localDataSource.saveListBackgrounds((backs as List<Backgrounds>?)!!)
        return backs
    }

}