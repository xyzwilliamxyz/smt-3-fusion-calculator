package com.think4software.smtfusioncalculator.ui.home

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.karumi.shot.ActivityScenarioUtils.waitForActivity
import com.think4software.smtfusioncalculator.BaseInstrumentedTest
import com.think4software.smtfusioncalculator.R
import com.think4software.smtfusioncalculator.utils.TabSelectionAction
import com.think4software.smtfusioncalculator.utils.disableSmoothAnimation
import org.junit.After
import org.junit.Test


class HomeActivityTest: BaseInstrumentedTest() {

    private lateinit var scenario: ActivityScenario<HomeActivity>

    @After
    fun tearDown() {
        scenario.close()
    }

    @Test
    fun launchActivity_withDemonListSelected_layoutIsAsExpected() {
        scenario = launchActivity()

        compareScreenshot(
            view = scenario.waitForActivity().findViewById(R.id.rootContainer)
        )
    }

    @Test
    fun launchActivity_withSkillsSelected_layoutIsAsExpected() {
        scenario = launchActivity()

        scenario.onActivity {
            it.findViewById<TabLayout>(R.id.tab_layout).disableSmoothAnimation(
                it.findViewById(R.id.pager)
            )
        }

        onView(withId(R.id.tab_layout)).perform(TabSelectionAction(1))

        compareScreenshot(
            view = scenario.waitForActivity().findViewById(R.id.rootContainer)
        )
    }
}