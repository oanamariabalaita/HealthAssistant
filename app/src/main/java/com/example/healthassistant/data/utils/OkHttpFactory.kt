package com.example.healthassistant.data.utils

import okhttp3.CertificatePinner
import okhttp3.ConnectionSpec
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.X509TrustManager

object OkHttpFactory {

    fun createOkHttpClient(
        interceptors: Set<Interceptor>,
        certificatePinner: CertificatePinner
    ): OkHttpClient {
        val builder = OkHttpClient().newBuilder()
            .connectionSpecs(listOf(ConnectionSpec.CLEARTEXT, ConnectionSpec.COMPATIBLE_TLS))
            .readTimeout(120000L, TimeUnit.MILLISECONDS)
            .connectTimeout(120000L, TimeUnit.MILLISECONDS)
            .certificatePinner(certificatePinner)

        interceptors.forEach { builder.addInterceptor(it) }
        return builder.build()
    }

    fun createDebugOkHttpClient(interceptors: Set<Interceptor>): OkHttpClient {

        val noCheckTrustManager = object : X509TrustManager {

            override fun checkClientTrusted(p0: Array<out X509Certificate>?, p1: String?) = Unit

            override fun checkServerTrusted(p0: Array<out X509Certificate>?, p1: String?) = Unit

            override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()
        }

        val sslContext = SSLContext.getInstance("SSL")
        sslContext.init(null, arrayOf(noCheckTrustManager), null)
        val sslSocketFactory = sslContext.socketFactory

        val builder = OkHttpClient().newBuilder()
            .connectionSpecs(listOf(ConnectionSpec.CLEARTEXT, ConnectionSpec.COMPATIBLE_TLS))
            .sslSocketFactory(sslSocketFactory, noCheckTrustManager)
            .hostnameVerifier(HostnameVerifier { _, _ -> true })
            .readTimeout(120000L, TimeUnit.MILLISECONDS)
            .connectTimeout(120000L, TimeUnit.MILLISECONDS)

        interceptors.forEach { builder.addInterceptor(it) }
        return builder.build()
    }
}
