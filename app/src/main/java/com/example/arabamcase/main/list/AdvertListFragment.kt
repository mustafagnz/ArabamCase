package com.example.arabamcase.main.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.arabamcase.adapter.AdvertListAdapter
import com.example.arabamcase.databinding.FragmentAdvertListBinding
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class AdvertListFragment : Fragment() {

    private var _binding: FragmentAdvertListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ListViewModel by viewModels()

    private var advertAdapter: AdvertListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAdvertListBinding.inflate(inflater, container, false)
        binding?.viewModel = viewModel
        binding?.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadData()
    }


    private fun loadData() {
        lifecycleScope.launch {
            viewModel.listData.collectLatest { pagingData ->
                advertAdapter?.submitData(pagingData)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        advertAdapter = null
        lifecycleScope.cancel()
    }
}
