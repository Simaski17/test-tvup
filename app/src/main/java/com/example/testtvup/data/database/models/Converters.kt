package com.example.testtvup.data.database.models

import androidx.room.TypeConverter
import com.example.domain.Item
import com.google.gson.Gson

class Converters {

    @TypeConverter
    fun listToJson(value: List<Item>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<Item>::class.java).toList()


}