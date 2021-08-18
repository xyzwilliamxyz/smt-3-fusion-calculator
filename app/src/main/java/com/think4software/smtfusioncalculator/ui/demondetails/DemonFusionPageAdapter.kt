package com.think4software.smtfusioncalculator.ui.demondetails

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.think4software.smtfusioncalculator.domain.model.Demon
import com.think4software.smtfusioncalculator.ui.demondetails.forwardfusion.ForwardFusionFragment
import com.think4software.smtfusioncalculator.ui.demondetails.reversefusion.ReverseFusionFragment

class DemonFusionPageAdapter(activity: FragmentActivity, val demon: Demon): FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return TAB_COUNT
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            REVERSE_FUSION_TAB -> ReverseFusionFragment.getInstance(demon.reverseFusions)
            FORWARD_FUSION_TAB -> ForwardFusionFragment.getInstance(demon.forwardFusions)
            else -> throw IllegalStateException("No tab at such position")
        }
    }

    companion object {
        private const val REVERSE_FUSION_TAB = 0
        private const val FORWARD_FUSION_TAB = 1
        private const val TAB_COUNT = 2
    }
}