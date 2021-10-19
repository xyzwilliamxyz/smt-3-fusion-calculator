package com.think4software.smtfusioncalculator.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.think4software.smtfusioncalculator.ui.demonlist.DemonListFragment
import com.think4software.smtfusioncalculator.ui.skilllist.SkillListFragment

class HomePageAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return TAB_COUNT
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            DEMONS_TAB -> DemonListFragment.getInstance()
            SKILLS_TAB -> SkillListFragment.getInstance()
            else -> throw IllegalStateException("No tab at such position")
        }
    }

    companion object {
        private const val DEMONS_TAB = 0
        private const val SKILLS_TAB = 1
        const val TAB_COUNT = 2
    }
}
