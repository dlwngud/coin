package com.wngud.coin.repository

import com.wngud.coin.model.CoinInfo

class CoinListRepository(private val remoteDataSource: CoinListRemoteDataSource) {
    suspend fun getCoinNameList():List<CoinInfo> {
        return remoteDataSource.getCoinNameList()
    }
}