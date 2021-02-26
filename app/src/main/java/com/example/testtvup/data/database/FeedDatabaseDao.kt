package com.example.testtvup.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface FeedDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBackgrounds(background: List<Backgrounds>)

}