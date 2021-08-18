package com.think4software.smtfusioncalculator.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ReverseFusion(
    val ingredientOne: FusionIngredient,
    val ingredientTwo: FusionIngredient,
): Parcelable
