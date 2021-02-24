package com.example.testtvup.data.server

import com.example.data.source.RemoteDataSource

class TheFeedDbDatasource (private val theFeedDbService: TheFeedDbService) : RemoteDataSource {

    override suspend fun getListFeed(): List<String> {

        val listFeed = theFeedDbService.getListFeed().execute().body()!!

        return listFeed

    }

}