package com.wngud.coin.repository

import com.wngud.coin.model.CoinInfo
import com.wngud.coin.network.ApiClient

class CoinListRemoteDataSource(private val api: ApiClient) {

    suspend fun getCoinNameList():List<CoinInfo> {
        return api.getCoinNameList()
    }
}