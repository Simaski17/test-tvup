package com.example.testtvup.data

import com.example.domain.Backgrounds
import com.example.domain.ResponseIMDB
import com.example.testtvup.data.database.models.Backgrounds as DomainBackground
import com.example.testtvup.data.database.models.ResponseIMDB as DomainResponseIMDB

fun Backgrounds.toRoomBackground() : DomainBackground =
    DomainBackground(
       imageUrl
    )

fun DomainBackground.toDomainBackground(): Backgrounds =
    Backgrounds(
        imageUrl
    )

fun ResponseIMDB.toRoomResponseIMDB () : DomainResponseIMDB =
    DomainResponseIMDB(
        description,
        id,
        image,
        items,
        title
    )
