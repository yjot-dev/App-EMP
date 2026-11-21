package com.yjotdev.empprimaria.data.remote.network

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import com.yjotdev.empprimaria.data.local.preferences.DevicePreferences

class HeaderInterceptor @Inject constructor(
    private val devicePreferences: DevicePreferences
): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Accept","application/json")
            .addHeader("Content-Type","application/json")
            .header("X-Device-Id", devicePreferences.getDeviceId())
            .build()
        return chain.proceed(request)
    }
}