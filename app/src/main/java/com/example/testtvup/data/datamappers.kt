package com.example.testtvup.data

import com.example.domain.Backgrounds
import com.example.testtvup.data.database.Backgrounds as DomainBackground

fun Backgrounds.toRoomBackground() : DomainBackground =
    DomainBackground(
       imageUrl
    )

fun DomainBackground.toDomainBackground(): Backgrounds =
    Backgrounds(
        imageUrl
    )