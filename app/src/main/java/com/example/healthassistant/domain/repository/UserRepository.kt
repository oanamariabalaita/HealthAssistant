package com.example.healthassistant.domain.repository

import com.example.healthassistant.data.api.UserApiService
import com.example.healthassistant.data.db.UserDao
import com.example.healthassistant.domain.utils.networking.toModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val userDao: UserDao,
    private val userService: UserApiService
) : BaseRepository() {

    suspend fun getUserInfo(userId: Long) =
        apiRequest {
            userService.getUserInfo(userId).toModel()
        }
}
