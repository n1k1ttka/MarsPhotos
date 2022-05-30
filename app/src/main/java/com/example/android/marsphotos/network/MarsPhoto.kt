package com.example.android.marsphotos.network

import com.squareup.moshi.Json

data class MarsPhoto(
    val id: String,
    @Json(name = "img_src") val imgSrcUrl: String) { // JSON аннотация используется, чтобы использовать имена переменных в классе данных, отличные от имен ключей в ответе JSON
}