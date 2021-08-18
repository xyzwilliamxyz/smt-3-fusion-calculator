package com.think4software.smtfusioncalculator.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FusionIngredient(
    val demonId: Int,
    val race: String,
    val level: Int,
    val name: String,
): Parcelable
