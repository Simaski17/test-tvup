package com.example.domain

data class Item (
        val art: String,
        val description: String,
        val director: String,
        val duration: Long,
        val id: String,
        val title: String,
        val url: String,
        val year: Long,
        val ratings: List<String>? = null
)