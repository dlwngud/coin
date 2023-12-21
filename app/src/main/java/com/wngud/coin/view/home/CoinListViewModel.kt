package com.wngud.coin.view.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wngud.coin.model.CoinInfo
import com.wngud.coin.repository.CoinListRepository
import kotlinx.coroutines.launch

class CoinListViewModel(private val coinListRepository: CoinListRepository):
    ViewModel() {

    private val _coins = MutableLiveData<List<CoinInfo>>()
    val coins: LiveData<List<CoinInfo>> = _coins

    init {
        loadCoinList()
    }

    private fun loadCoinList() = viewModelScope.launch {
        val coinList = coinListRepository.getCoinNameList()
        _coins.value = coinList
        Log.d("qwe", coinList.toString())
    }
}