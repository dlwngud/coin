package com.wngud.coin.repository

import com.wngud.coin.model.CoinInfo
import com.wngud.coin.model.CurrentCoinPrice

class CoinListRepository(private val remoteDataSource: CoinListRemoteDataSource) {
    suspend fun getCoinNameList(): List<CoinInfo> {
        return remoteDataSource.getCoinNameList()
    }

    suspend fun getCoinsPrice(market: String): List<CurrentCoinPrice> {
        return remoteDataSource.getCoinsPrice(market)
    }
}