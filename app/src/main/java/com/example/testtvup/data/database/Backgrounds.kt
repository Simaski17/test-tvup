package com.example.testtvup.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Backgrounds (
        @PrimaryKey(autoGenerate = false)
        val imageUrl: String
)