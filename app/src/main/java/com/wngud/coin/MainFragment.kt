package com.wngud.coin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.wngud.coin.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.run {
            val navHostFragment =
                requireActivity().supportFragmentManager.findFragmentById(R.id.container_main) as NavHostFragment
            val navController = navHostFragment.findNavController()
            bottomNavigation.setupWithNavController(navController)

            bottomNavigation.setOnItemSelectedListener { menuItem ->
                if(menuItem.itemId == R.id.navigation_community || menuItem.itemId == R.id.navigation_information){
                    val dialogBuilder = AlertDialog.Builder(requireContext())
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

                        dialog.dismiss()
                    }

                    val dialog = dialogBuilder.create()
                    dialog.show()
                    false
                }else{
                    when(menuItem.itemId){
                        R.id.navigation_coin -> {
                            true
                        }
                        else -> {
                            false
                        }
                    }
                }
            }
        }
        return binding.root
    }
}