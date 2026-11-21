package com.yjotdev.empprimaria.data.remote.network

import javax.inject.Inject
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor
import com.yjotdev.empprimaria.BuildConfig
import com.yjotdev.empprimaria.data.remote.core.NullOnEmptyConverterFactory

@Singleton
class RetrofitBuilder @Inject constructor(
    headerInterceptor: HeaderInterceptor,
    loggingInterceptor: HttpLoggingInterceptor
) {
    // Configuración dinámica de URL según el entorno
    private val baseUrl = BuildConfig.API_BASE_URL

    // Configuración de cliente HTTP
    private val client = okhttp3.OkHttpClient.Builder()
        .addInterceptor(headerInterceptor)
        .addInterceptor(loggingInterceptor)
        .build()

    /**
     * Construye y devuelve una instancia configurada de Retrofit.
     * Este es ahora el único punto de configuración de red para toda la app.
     */
    fun getRetrofitInstance(): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .addConverterFactory(NullOnEmptyConverterFactory())
        .build()
}