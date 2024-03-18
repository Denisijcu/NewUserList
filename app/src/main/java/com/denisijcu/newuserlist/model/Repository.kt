package com.denisijcu.newuserlist.model

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

//const val url = "https://script.google.com/macros/s/AKfycbz6pistTsVtMekJY6Eu72Br59X3FamRpSXxCDJ2LLQsXtQaWs02JrmRoxEaBj6UreUDqQ/"

// Retrofit Setup
private const val url="https://script.google.com/macros/s/AKfycbz6pistTsVtMekJY6Eu72Br59X3FamRpSXxCDJ2LLQsXtQaWs02JrmRoxEaBj6UreUDqQ/"
val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl(url)
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

val apiService: ApiService = retrofit.create(ApiService::class.java)
