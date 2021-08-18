package com.think4software.smtfusioncalculator.utils

import android.view.View
import androidx.test.espresso.PerformException
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.google.android.material.tabs.TabLayout
import org.hamcrest.Matcher
import org.hamcrest.core.AllOf.allOf

class TabSelectionAction(
    private val tabIndex: Int
): ViewAction {
    override fun getDescription() = "with tab at index $tabIndex"

    override fun getConstraints(): Matcher<View> = allOf(isDisplayed(), isAssignableFrom(TabLayout::class.java))

    override fun perform(uiController: UiController, view: View) {
        val tabLayout = view as TabLayout
        val tabAtIndex: TabLayout.Tab = tabLayout.getTabAt(tabIndex)
            ?: throw PerformException.Builder()
                .withCause(Throwable("No tab at index $tabIndex"))
                .build()

        tabAtIndex.select()
    }
}