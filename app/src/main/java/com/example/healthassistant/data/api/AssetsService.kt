package com.example.healthassistant.data.api

import com.example.healthassistant.data.model.FileResponse
import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

interface AssetsService {

    companion object {
        private const val POST_ASSET = "assets/{assetKey}"
    }

    @Multipart
    @POST(POST_ASSET)
    suspend fun postFileAsset(
        @Path("assetKey") key: String,
        @Part file: MultipartBody.Part
    ): FileResponse
}
