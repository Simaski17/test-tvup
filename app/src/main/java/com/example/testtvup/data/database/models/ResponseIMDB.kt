package com.example.testtvup.data.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.domain.Item

@Entity
data class ResponseIMDB (
    val description: String,
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val image: String,
    @TypeConverters(Converters::class)
    val items: List<Item>,
    val title: String
)