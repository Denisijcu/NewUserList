package com.denisijcu.newuserlist.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.denisijcu.newuserlist.model.User
import com.denisijcu.newuserlist.model.apiService

// ViewModel
class MainViewModel {
    var users by mutableStateOf<List<User>>(emptyList())
        private set

    suspend fun fetchData() {
        users = apiService.getUsers()
    }
}
