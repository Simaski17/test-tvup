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