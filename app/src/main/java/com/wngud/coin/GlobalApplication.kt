package com.wngud.coin

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class GlobalApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        KakaoSdk.init(this, "d226e94f33265efcf6e71c40d55a75a7")
    }
}