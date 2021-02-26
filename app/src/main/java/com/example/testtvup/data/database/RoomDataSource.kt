package com.example.testtvup.data.database

import com.example.data.source.LocalDataSource
import com.example.domain.Backgrounds
import com.example.testtvup.data.toRoomBackground
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomDataSource(db: FeedDatabase): LocalDataSource {

    private val feedDao = db.feedDao()

    override suspend fun saveListBackgrounds(feed: List<Backgrounds>) {
        withContext(Dispatchers.IO) { feedDao.insertBackgrounds(background = feed.map { it.toRoomBackground() }) }
    }


}