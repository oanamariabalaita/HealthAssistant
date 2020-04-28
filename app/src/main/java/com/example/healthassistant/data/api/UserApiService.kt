package com.example.healthassistant.data.api

import com.example.healthassistant.data.model.User
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface UserApiService {

    @GET("users")
    fun getAllUsers(): Observable<List<User>>

    @GET("users")
    fun getUserById(@Path("userId") id: Long): Observable<User>

    @POST
    fun addUser(@Body user: User): Single<Any>

    @PUT
    fun updateUser(@Path("userId") id: Long, @Body user: User): Single<Any>

    @DELETE("users")
    fun deleteUser(@Path("userId") id: Long): Single<Any>
}
