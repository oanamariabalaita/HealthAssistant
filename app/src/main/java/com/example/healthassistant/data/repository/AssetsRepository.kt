package com.example.healthassistant.data.repository

import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import com.example.healthassistant.data.api.AssetsService
import com.example.healthassistant.data.model.FileResponse
import com.example.healthassistant.utils.scaleImage
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.io.FileNotFoundException
import java.util.UUID
import javax.inject.Inject

class AssetsRepository @Inject constructor() : IAssetsRepository {

    @Inject
    private lateinit var assetsService: AssetsService

    @Inject
    private lateinit var context: Context

    override suspend fun postImageAsset(key: String, fileUriString: String): FileResponse {
        val bytes = try {
            val uri = Uri.parse(fileUriString)
            context.contentResolver.openInputStream(uri)?.readBytes()
        } catch (e: FileNotFoundException) {
            val uri = Uri.fromFile(File(fileUriString))
            context.contentResolver.openInputStream(uri)?.readBytes()
        } ?: throw IllegalStateException("InputStream is null")

        val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)

        val file = scaleImage(bitmap)
        val mediaType = MediaType.parse("image/*")

        val multiPartBody = if (file != null) {
            val body = RequestBody.create(mediaType, file)
            MultipartBody.Part.createFormData("file", file.name, body)
        } else {
            val body = RequestBody.create(mediaType, bytes)
            MultipartBody.Part.createFormData("file", UUID.randomUUID().toString(), body)
        }

        return assetsService.postFileAsset(key, multiPartBody)
    }
}
