package com.wngud.coin.network

import com.wngud.coin.model.CoinInfo
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiClient {

    @GET("market/all")
    suspend fun getCoinNameList(): List<CoinInfo>

    companion object {

        private const val BASE_URL = "https://api.upbit.com/v1/"

        fun create(): ApiClient {

            return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiClient::class.java)
        }
    }
}