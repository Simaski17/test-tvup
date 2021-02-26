package com.example.testtvup.data.server

import com.example.data.source.RemoteDataSource
import com.example.domain.Backgrounds
import com.example.domain.ResponseIMDB

class TheFeedDbDatasource (private val theFeedDbService: TheFeedDbService) : RemoteDataSource {

    override suspend fun getListFeed(): List<Backgrounds> {

        var arryList: ArrayList<Backgrounds> = arrayListOf<Backgrounds>()

        val listFeed = theFeedDbService.getListFeed().execute().body()!!

        listFeed.forEach {
            arryList.add(Backgrounds(imageUrl = it))
        }

        return arryList

    }

    override suspend fun getListMovies(): List<ResponseIMDB> {
        return theFeedDbService.getListMovies().execute().body()!!
    }

}