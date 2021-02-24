package com.example.healthassistant.data.utils.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import java.util.UUID

class HeaderInterceptor : Interceptor {

    companion object {

        private const val SESSION_ID_HEADER = "SessionId"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        return chain.proceed(
            originalRequest.newBuilder()
                .header(
                    SESSION_ID_HEADER,
                    "healthAssistantApp_MockAppId_" + UUID.randomUUID().toString()
                )
                .build()
        )
    }
}
