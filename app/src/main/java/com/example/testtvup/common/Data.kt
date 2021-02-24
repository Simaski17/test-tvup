package com.example.falabellatest.ui.common

data class Data<out T>(val dataState: DataState,
                       val data: T? = null,
                       val exception: Throwable? = null)