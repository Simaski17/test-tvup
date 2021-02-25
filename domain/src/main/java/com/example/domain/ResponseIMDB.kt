package com.example.domain

import kotlinx.serialization.*


@Serializable
data class ResponseIMDB (
    val description: String,
    val id: String,
    val image: String,
    val items: List<Item>,
    val title: String
)

@Serializable
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