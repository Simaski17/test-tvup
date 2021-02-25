package com.example.data.repository

import com.example.data.source.LocalDataSource
import com.example.data.source.RemoteDataSource
import com.example.domain.ResponseIMDB

class FeedMoviesRepository (private val localDataSource: LocalDataSource, private val remoteDataSource: RemoteDataSource)  {

    suspend fun getListMovies(): List<ResponseIMDB> {
        var movies = remoteDataSource.getListMovies()
        //localDataSource.saveListBackgrounds((backs as List<Backgrounds>?)!!)
        return movies
    }

}