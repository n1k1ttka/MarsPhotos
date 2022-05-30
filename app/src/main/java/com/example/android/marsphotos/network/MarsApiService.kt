package com.example.android.marsphotos.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST

private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com" // TODO Базовый URL-адрес где находятся искомые ресурсы
private val moshi = Moshi.Builder() // TODO Конструктор Moshi для сборки и создания объекта Moshi
    .add(KotlinJsonAdapterFactory()) // TODO Чтобы аннотации Moshi правильно работали с Kotlin
    .build() // TODO Создали объект Moshi
private val retrofit = Retrofit.Builder() // TODO Конструктор Retrofit для сборки и создания объекта Retrofit
    .addConverterFactory(MoshiConverterFactory.create(moshi)) // TODO Конвертер (в него передаем объект Moshi) сообщает Retrofit, что делать с данными, которые он получает
    .baseUrl(BASE_URL) // TODO Поместили базовый URL/Создали URI
    .build() // TODO Создали объект Retrofit

interface MarsApiService {

    @GET ("photos") // TODO Когда getPhotos() метод вызывается, Retrofit добавляет конечную точку photos к базовому URL-адресу с помощью запроса GET
    suspend fun getPhotos(): List<MarsPhoto>
}

object MarsApi {
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)}
}