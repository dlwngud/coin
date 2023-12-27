package com.wngud.coin.model

data class CoinInfo(
    val market: String,
    val korean_name: String,
    val english_name: String,
    val isInteresting: Boolean = false,
    val price: CurrentCoinPrice? = null
)
