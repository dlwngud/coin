package com.wngud.coin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wngud.coin.network.ServiceLocator
import com.wngud.coin.repository.CoinListRemoteDataSource
import com.wngud.coin.repository.CoinListRepository
import com.wngud.coin.view.home.CoinListViewModel

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(CoinListViewModel::class.java) -> {
                // Hilt로 의존성 주입을 해줄 수 있다.
                val repository = CoinListRepository(CoinListRemoteDataSource(ServiceLocator.provideApiClient()))
                CoinListViewModel(repository) as T
            }

            else -> {
                throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
            }
        }
    }
}