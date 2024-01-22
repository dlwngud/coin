package com.wngud.coin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kakao.sdk.common.util.Utility
import com.wngud.coin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val keyHash = Utility.getKeyHash(this)
        Log.d("Hash", keyHash)

        binding.run {
            val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.container_main) as NavHostFragment
            val navController = navHostFragment.findNavController()
            bottomNavigation.setupWithNavController(navController)

            bottomNavigation.setOnItemSelectedListener { menuItem ->
                if(menuItem.itemId == R.id.navigation_community || menuItem.itemId == R.id.navigation_information){
                    val dialogBuilder = AlertDialog.Builder(this@MainActivity)
                    dialogBuilder.setTitle("로그인이 필요합니다.")
                    dialogBuilder.setMessage("한 번만 하면 됩니다.")
                    dialogBuilder.setCancelable(true)

                    dialogBuilder.setNegativeButton("취소") { dialog, _ ->
                        // 취소 버튼 클릭 시 처리할 내용
                        dialog.dismiss()
                    }

                    dialogBuilder.setPositiveButton("로그인") { dialog, _ ->
                        // 로그인 버튼 클릭 시 처리할 내용
                        // 예: 로그인 화면으로 이동
                        findNavController(R.id.container_main).navigate(R.id.loginFragment)
                        val bottomNavigationView = this@MainActivity.findViewById<BottomNavigationView>(R.id.bottom_navigation)
                        bottomNavigationView?.visibility = View.GONE

                        dialog.dismiss()
                    }

                    val dialog = dialogBuilder.create()
                    dialog.show()
                    false
                }else{
                    when(menuItem.itemId){
                        R.id.navigation_home -> {
                            true
                        }
                        else -> {
                            false
                        }
                    }
                }
            }
        }
    }
}

// <a href="https://www.flaticon.com/kr/free-icons/-" title="비트 코인 아이콘">비트 코인 아이콘  제작자: YI-PIN - Flaticon</a>