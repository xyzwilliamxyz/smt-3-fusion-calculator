package com.think4software.smtfusioncalculator.utils

import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

fun TabLayout.disableSmoothAnimation(pager: ViewPager2) {
    this.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
        override fun onTabReselected(tab: TabLayout.Tab?) {
        }

        override fun onTabUnselected(tab: TabLayout.Tab?) {
        }

        override fun onTabSelected(tab: TabLayout.Tab?) {
            tab?.position?.let { pager.setCurrentItem(it, false) }
        }
    })
}