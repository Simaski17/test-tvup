package com.example.domain

data class FeedIMDB (
        val description: String,
        val id: String,
        val image: String,
        val items: List<Item>,
        val title: String
)

