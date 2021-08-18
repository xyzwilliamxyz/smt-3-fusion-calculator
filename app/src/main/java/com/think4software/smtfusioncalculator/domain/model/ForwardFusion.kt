package com.think4software.smtfusioncalculator.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ForwardFusion(
    val ingredientTwo: FusionIngredient,
    val result: FusionIngredient,
): Parcelable
