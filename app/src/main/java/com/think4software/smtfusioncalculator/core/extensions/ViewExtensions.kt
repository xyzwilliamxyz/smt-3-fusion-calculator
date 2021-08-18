package com.think4software.smtfusioncalculator.core.extensions

import android.view.View
import androidx.core.content.ContextCompat
import com.think4software.smtfusioncalculator.R

fun View.applyOddOrEvenColor(index: Int) {
    val lineBackgroundColor = if (index % 2 == 0) {
        R.color.line_even
    } else {
        R.color.line_odd
    }

    setBackgroundColor(ContextCompat.getColor(context, lineBackgroundColor))
}