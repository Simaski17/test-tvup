package com.example.testtvup.data.database

import com.example.data.source.LocalDataSource

class RoomDataSource(db: FeedDatabase): LocalDataSource {

    override suspend fun saveListBackgrounds(users: List<String>) {
        TODO("Not yet implemented")
    }

}