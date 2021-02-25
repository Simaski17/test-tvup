package com.example.testtvup.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.testtvup.data.database.models.Backgrounds
import com.example.testtvup.data.database.models.Converters
import com.example.testtvup.data.database.models.ResponseIMDB

@Database(entities = [Backgrounds::class, ResponseIMDB::class], version = 1)
@TypeConverters(Converters::class)
abstract class FeedDatabase : RoomDatabase() {

    abstract fun feedDao(): FeedDatabaseDao

}