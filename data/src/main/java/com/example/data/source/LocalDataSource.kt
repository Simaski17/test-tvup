package com.example.data.source

import com.example.domain.Backgrounds

interface LocalDataSource {

    suspend fun saveListBackgrounds(feed: List<Backgrounds>)

}