package com.example.testtvup.data

import com.example.domain.Backgrounds
import com.example.testtvup.data.database.Backgrounds as DomainBackground

fun Backgrounds.toRoomUser() : DomainBackground =
    DomainBackground(
       imageUrl
    )

fun DomainBackground.toDomainuser(): Backgrounds =
    Backgrounds(
        imageUrl
    )