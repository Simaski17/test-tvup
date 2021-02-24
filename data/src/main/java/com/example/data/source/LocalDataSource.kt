package com.example.data.source

interface LocalDataSource {

    suspend fun saveListBackgrounds(users: List<String>)

}