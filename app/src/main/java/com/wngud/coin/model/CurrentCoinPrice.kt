package com.wngud.coin.model

data class CurrentCoinPrice(
    val market: String,
    val opening_price: Double,
    val trade_price: Double,
    val change: String,
)
