package com.example.testtvup.data.database

import com.example.data.source.LocalDataSource
import com.example.domain.Backgrounds
import com.example.domain.Item
import com.example.domain.ResponseIMDB
import com.example.testtvup.data.toDomainResponseIMDB
import com.example.testtvup.data.toRoomBackground
import com.example.testtvup.data.toRoomResponseIMDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomDataSource(db: FeedDatabase): LocalDataSource {

    private val feedDao = db.feedDao()

    override suspend fun saveListBackgrounds(feed: List<Backgrounds>) {
        withContext(Dispatchers.IO) { feedDao.insertBackgrounds(background = feed.map { it.toRoomBackground() }) }
    }

    override suspend fun saveListMovies(movies: List<ResponseIMDB>) {
        withContext(Dispatchers.IO) { feedDao.insertMovies(movies = movies.map { it.toRoomResponseIMDB() }) }
    }

    override suspend fun findMovieById(): List<ResponseIMDB> = withContext(Dispatchers.IO) {
        feedDao.findMovieById().map { it.toDomainResponseIMDB() }
    }

}