package com.think4software.smtfusioncalculator.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.think4software.smtfusioncalculator.R
import com.think4software.smtfusioncalculator.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViews()
    }

    @SuppressLint("WrongConstant") // false positive from lint
    private fun setupViews() {
        binding.pager.offscreenPageLimit = HomePageAdapter.TAB_COUNT
        binding.pager.adapter = HomePageAdapter(this)
        setTabTitles()
    }

    private fun setTabTitles() {
        TabLayoutMediator(
            binding.tlFusionsList, binding.pager
        ) { tab, position ->
            tab.text = getString(TAB_TITLES[position])
        }.attach()
    }

    companion object {
        private val TAB_TITLES = arrayOf(R.string.tab_demons, R.string.tab_skills)
    }
}
