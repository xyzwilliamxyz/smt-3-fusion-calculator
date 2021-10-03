package com.think4software.smtfusioncalculator.ui.skilllist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.think4software.smtfusioncalculator.databinding.FragmentSkillListBinding
import com.think4software.smtfusioncalculator.domain.model.Skill
import org.koin.androidx.viewmodel.ext.android.viewModel


class SkillListFragment: Fragment() {

    private val viewModel: SkillListViewModel by viewModel()
    private var _binding: FragmentSkillListBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: SkillListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSkillListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViews()
        setupObservables()
        viewModel.getSkills()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupViews() {
        binding.iHeader.level.isVisible = false
        binding.container.isVisible = false
        binding.pbLoading.isVisible = false

        adapter = SkillListAdapter(requireActivity())
        binding.skillList.adapter = adapter
    }

    private fun setupObservables() {
        viewModel.screenState.observe(requireActivity()) {
            when (it) {
                is SkillListViewModel.ScreenState.Success -> {
                    binding.container.isVisible = true
                    binding.pbLoading.isVisible = false
                    setListData(it.data)
                }
                else -> {
                    binding.pbLoading.isVisible = true
                }
            }
        }
    }

    private fun setListData(skills: List<Skill>) {
        adapter.setData(skills)
    }

    companion object {
        fun getInstance(): SkillListFragment {
            return SkillListFragment()
        }
    }
}