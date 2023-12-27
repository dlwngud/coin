package com.wngud.coin.view.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wngud.coin.model.CoinInfo
import com.wngud.coin.model.CurrentCoinPrice
import com.wngud.coin.repository.CoinListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoinListViewModel(private val coinListRepository: CoinListRepository) :
    ViewModel() {

    private val _coins = MutableLiveData<List<CoinInfo>>()
    val coins: LiveData<List<CoinInfo>> = _coins

    init {
        loadCoinList()
    }

    private fun loadCoinList() = viewModelScope.launch {
        var coinList = coinListRepository.getCoinNameList().toMutableList()
        var coinNames = ""
        for (coin in coinList) {
            coinNames += coin.market + ","
        }
        coinNames = coinNames.trimEnd(',')
        withContext(Dispatchers.Default) {
            val coinsPrice = coinListRepository.getCoinsPrice(coinNames)
            coinList.forEachIndexed { index, coinInfo ->
                coinList[index] = CoinInfo(
                    market = coinInfo.market,
                    korean_name = coinInfo.korean_name,
                    english_name = coinInfo.english_name,
                    isInteresting = coinInfo.isInteresting,
                    price = coinsPrice[index]
                )
            }
        }

        _coins.value = coinList
        Log.d("qwe", coinList.toString())
    }
}