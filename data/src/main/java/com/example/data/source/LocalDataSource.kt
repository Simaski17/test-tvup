package com.example.data.source

import com.example.domain.Backgrounds
import com.example.domain.ResponseIMDB

interface LocalDataSource {

    suspend fun saveListBackgrounds(feed: List<Backgrounds>)

}