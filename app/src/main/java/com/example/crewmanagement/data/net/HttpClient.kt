package com.example.crewmanagement.data.net

import android.annotation.SuppressLint
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.security.SecureRandom
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.X509TrustManager

class HttpClient {

    class Builder(
        private var ignoreSSL: Boolean = true,
        private var interceptors: MutableList<Interceptor> = mutableListOf(),
    ) {
        fun ignoreSSL(ignoreSSL: Boolean) = apply { this.ignoreSSL = ignoreSSL }

        fun interceptors(interceptors: List<Interceptor>) = apply {
            this.interceptors.addAll(interceptors)
        }

        fun build(): OkHttpClient {
            val builder = OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT_SECONDS, TimeUnit.SECONDS)

            interceptors.forEach { interceptor ->
                builder.addInterceptor(interceptor)
            }

            val sslContext = SSLContext.getInstance(SSL_PROTOCOL)

            if (ignoreSSL) {
                val sslContext = SSLContext.getInstance(SSL_PROTOCOL).apply {
                    init(null, arrayOf(emptyTrustManager), SecureRandom())
                }

                builder
                    .sslSocketFactory(
                        sslContext.socketFactory,
                        emptyTrustManager
                    )
                    .hostnameVerifier { _, _ -> true }
            }

            return builder.build()
        }
    }

    companion object {
        const val CONNECT_TIMEOUT_SECONDS = 30L
        const val READ_TIMEOUT_SECONDS = 30L
        const val WRITE_TIMEOUT_SECONDS = 30L
        const val SSL_PROTOCOL = "SSL"

        private val emptyTrustManager = object : X509TrustManager {
            @SuppressLint("TrustAllX509TrustManager")
            override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {
                // Nothing to do
            }

            @SuppressLint("TrustAllX509TrustManager")
            override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {
                // Nothing to do
            }

            override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()
        }
    }
}
