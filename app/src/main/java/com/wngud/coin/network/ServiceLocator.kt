package com.wngud.coin.network

object ServiceLocator {
    private var apiClient: ApiClient? = null

    fun provideApiClient(): ApiClient {
        return apiClient ?: kotlin.run {
            ApiClient.create().also {
                apiClient = it
            }
        }
    }
}