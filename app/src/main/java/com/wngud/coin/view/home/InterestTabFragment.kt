package com.wngud.coin.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.wngud.coin.R
import com.wngud.coin.ViewModelFactory
import com.wngud.coin.databinding.FragmentInterestTabBinding

class InterestTabFragment : Fragment() {

    private lateinit var binding: FragmentInterestTabBinding
    private val viewModel: CoinListViewModel by viewModels{ ViewModelFactory() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentInterestTabBinding.inflate(inflater, container, false)

        val coinListAdapter = CoinListAdapter(viewModel)

        viewModel.coins.observe(viewLifecycleOwner) {
            coinListAdapter.submitList(it)
        }

        binding.run {
            btnLogin.setOnClickListener {
                it.findNavController().navigate(R.id.action_main_to_login)
            }
        }

        return binding.root
    }
}