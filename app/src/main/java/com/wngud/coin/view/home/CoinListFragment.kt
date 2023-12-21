package com.wngud.coin.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.wngud.coin.ViewModelFactory
import com.wngud.coin.ViewPagerAdapter
import com.wngud.coin.databinding.FragmentCoinListBinding

class CoinListFragment : Fragment() {

    private lateinit var binding: FragmentCoinListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCoinListBinding.inflate(inflater, container, false)

        initViewPager()

        return binding.root
    }

    private fun initViewPager() {
        binding.run {
            val viewPagerAdapter = ViewPagerAdapter(requireActivity())
            viewPagerAdapter.addFragment(TotalTabFragment())
            viewPagerAdapter.addFragment(InterestTabFragment())

            tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {

                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {

                }

                override fun onTabReselected(tab: TabLayout.Tab?) {

                }

            })

            // 뷰페이저에 어댑터 연결
            viewpager.adapter = viewPagerAdapter

            // 탭과 뷰페이저를 연결, 여기서 새로운 탭을 다시 만드므로 레이아웃에서 꾸미지말고 여기서 꾸며야함
            TabLayoutMediator(tabs, viewpager) { tab, position ->
                tab.text = when (position) {
                    0 -> "전체"
                    else -> "관심"
                }
            }.attach()
        }
    }
}