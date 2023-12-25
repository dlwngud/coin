package com.wngud.coin.view.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wngud.coin.model.CoinInfo
import com.wngud.coin.model.CurrentCoinPrice
import com.wngud.coin.repository.CoinListRepository
import kotlinx.coroutines.launch

class CoinListViewModel(private val coinListRepository: CoinListRepository) :
    ViewModel() {

    private val _coins = MutableLiveData<List<CoinInfo>>()
    val coins: LiveData<List<CoinInfo>> = _coins

    private val _coinsPrice = MutableLiveData<List<CurrentCoinPrice>>()
    val coinsPrice: LiveData<List<CurrentCoinPrice>> = _coinsPrice

    init {
        loadCoinList()
    }

    private fun loadCoinList() = viewModelScope.launch {
        val coinList = coinListRepository.getCoinNameList()
        _coins.value = coinList
        var coinNames = ""
        for (coin in coinList) {
            coinNames += coin.market + ","
        }
        coinNames = coinNames.trimEnd(',')
        Log.d("qwe", coinList.toString())
        loadCoinsPrice(coinNames)
    }

    fun loadCoinsPrice(market: String) = viewModelScope.launch {
        val coinsPrice = coinListRepository.getCoinsPrice(market)
        _coinsPrice.value = coinsPrice
        Log.d("qwe", coinsPrice.toString())
    }
}