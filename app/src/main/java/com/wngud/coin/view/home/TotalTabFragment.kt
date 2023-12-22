package com.wngud.coin.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.wngud.coin.R
import com.wngud.coin.ViewModelFactory
import com.wngud.coin.databinding.FragmentTotalTabBinding

class TotalTabFragment : Fragment() {

    private lateinit var binding: FragmentTotalTabBinding
    private val viewModel: CoinListViewModel by viewModels { ViewModelFactory() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTotalTabBinding.inflate(inflater, container, false)

        val coinListAdapter = CoinListAdapter(viewModel)

        viewModel.coins.observe(viewLifecycleOwner) {
            coinListAdapter.submitList(it)
        }

        binding.run {
            rvTotalTab.adapter = coinListAdapter
            rvTotalTab.layoutManager = LinearLayoutManager(requireContext())
            rvTotalTab.addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    LinearLayout.VERTICAL
                )
            )
        }

        return binding.root
    }
}