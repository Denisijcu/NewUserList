package com.denisijcu.newuserlist.model

import retrofit2.http.GET

// API Service Interface
interface ApiService {
    @GET("exec")
    suspend fun getUsers(): List<User>
}
