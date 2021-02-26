package com.example.testtvup.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Backgrounds::class], version = 1)
abstract class FeedDatabase : RoomDatabase() {

    abstract fun feedDao(): FeedDatabaseDao

}