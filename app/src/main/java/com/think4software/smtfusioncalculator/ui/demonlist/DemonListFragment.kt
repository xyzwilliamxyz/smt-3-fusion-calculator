package com.think4software.smtfusioncalculator.ui.demonlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.think4software.smtfusioncalculator.databinding.FragmentDemonListBinding
import com.think4software.smtfusioncalculator.domain.model.Demon
import com.think4software.smtfusioncalculator.ui.demondetails.DemonDetailsActivity
import com.think4software.smtfusioncalculator.ui.demonlist.DemonListViewModel.ScreenState
import org.koin.androidx.viewmodel.ext.android.viewModel

class DemonListFragment: Fragment() {

    private val viewModel: DemonListViewModel by viewModel()
    private var _binding: FragmentDemonListBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: DemonListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDemonListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservables()
        viewModel.getDemons()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupObservables() {
        viewModel.screenState.observe(requireActivity()) {
            when (it) {
                is ScreenState.Success -> {
                    binding.iHeader.root.isVisible = true
                    binding.rvDemonList.isVisible = true
                    binding.pbLoading.isVisible = false
                    setListData(it.data)
                }
                is ScreenState.Loading -> {
                    binding.pbLoading.isVisible = true
                    binding.iHeader.root.isVisible = false
                    binding.rvDemonList.isVisible = false
                }
            }
        }
    }

    private fun setListData(demonList: List<Demon>) {
        if (!::adapter.isInitialized) {
            adapter = DemonListAdapter(requireActivity(), demonList, ::openDemonDetailsScreen)
            binding.rvDemonList.adapter = adapter
        }
    }

    private fun openDemonDetailsScreen(demonId: Int) {
        startActivity(DemonDetailsActivity.getIntent(requireActivity(), demonId))
    }

    companion object {
        fun getInstance(): DemonListFragment {
            return DemonListFragment()
        }
    }
}