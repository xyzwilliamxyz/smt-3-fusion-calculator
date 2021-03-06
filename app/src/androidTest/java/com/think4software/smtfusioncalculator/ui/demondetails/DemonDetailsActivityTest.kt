package com.think4software.smtfusioncalculator.ui.demondetails

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.google.android.material.tabs.TabLayout
import com.karumi.shot.ActivityScenarioUtils.waitForActivity
import com.think4software.smtfusioncalculator.BaseInstrumentedTest
import com.think4software.smtfusioncalculator.R
import com.think4software.smtfusioncalculator.utils.TabSelectionAction
import com.think4software.smtfusioncalculator.utils.disableSmoothAnimation
import org.junit.After
import org.junit.Test

class DemonDetailsActivityTest: BaseInstrumentedTest() {

    private lateinit var scenario: ActivityScenario<DemonDetailsActivity>

    @After
    fun tearDown() {
        scenario.close()
    }

    @Test
    fun launchActivity_withDemonIdPassed_layoutIsAsExpected() {
        val intent = DemonDetailsActivity.getIntent(ApplicationProvider.getApplicationContext(), 53)
        scenario = launchActivity(intent)

        compareScreenshot(
            view = scenario.waitForActivity().findViewById(R.id.rootContainer)
        )
    }

    @Test
    fun launchActivity_withDemonIdPassedAndSelectsForwardFusions_layoutIsAsExpected() {
        val intent = DemonDetailsActivity.getIntent(ApplicationProvider.getApplicationContext(), 53)
        scenario = launchActivity(intent)

        scenario.onActivity {
            it.findViewById<TabLayout>(R.id.tlFusionsList).disableSmoothAnimation(
                it.findViewById(R.id.vpFusionsList)
            )
        }

        onView(withId(R.id.rootLayout)).perform(swipeUp())
        onView(withId(R.id.tlFusionsList)).perform(TabSelectionAction(1))

        compareScreenshot(
            view = scenario.waitForActivity().findViewById(R.id.rootContainer)
        )
    }
}