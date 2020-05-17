package com.example.healthassistant.data.repository

import com.example.healthassistant.data.model.FileResponse

interface IAssetsRepository {

    suspend fun postImageAsset(key: String, fileUriString: String): FileResponse
}
