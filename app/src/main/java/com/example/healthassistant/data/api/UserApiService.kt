package com.example.healthassistant.data.api

import com.example.healthassistant.data.model.UserEntity
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface UserApiService {

    companion object {
        private const val PREFIX = "profile/"
        private const val GET_USER_INFO = "$PREFIX/info"
        private const val POST_USER = "$PREFIX/add"
        private const val PUT_USER = "$PREFIX/details"
        private const val DELETE_USER = "$PREFIX/{userId}"
    }

    @GET(GET_USER_INFO)
    fun getUserInfo(@Path("userId") id: Long): UserEntity

    @POST(POST_USER)
    fun addUser(@Body user: UserEntity)

    @PUT(PUT_USER)
    fun updateUser(@Path("userId") id: Long, @Body user: UserEntity)

    @DELETE(DELETE_USER)
    fun deleteUser(@Path("userId") id: Long)
}
