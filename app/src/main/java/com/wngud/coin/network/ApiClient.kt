package com.wngud.coin.network

import com.wngud.coin.model.CoinInfo
import com.wngud.coin.model.CurrentCoinPrice
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("market/all")
    suspend fun getCoinNameList(): List<CoinInfo>

    @GET("ticker")
    suspend fun getCoinsPrice(@Query("markets") market: String): List<CurrentCoinPrice>


    companion object {

        private const val BASE_URL = "https://api.upbit.com/v1/"

        fun create(): ApiClient {

            return Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiClient::class.java)
        }
    }
}