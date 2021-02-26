package com.example.testtvup.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.domain.Item
import com.example.testtvup.data.database.models.Backgrounds
import com.example.testtvup.data.database.models.ResponseIMDB

@Dao
interface FeedDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBackgrounds(background: List<Backgrounds>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<ResponseIMDB>)

    @Query("SELECT * FROM ResponseIMDB")
    fun findMovieById(): List<ResponseIMDB>

}