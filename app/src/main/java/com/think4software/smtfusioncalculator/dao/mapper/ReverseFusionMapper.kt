package com.think4software.smtfusioncalculator.dao.mapper

import androidx.annotation.VisibleForTesting
import com.think4software.smtfusioncalculator.dao.join.ReverseFusionJoin
import com.think4software.smtfusioncalculator.domain.model.FusionIngredient
import com.think4software.smtfusioncalculator.domain.model.ReverseFusion

class ReverseFusionMapper {

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    fun toDomain(reverseFusionJoin: ReverseFusionJoin): ReverseFusion {
        return ReverseFusion(
            ingredientOne = FusionIngredient(
                demonId = reverseFusionJoin.ingredientOne.demonId,
                race = reverseFusionJoin.ingredientOne.race,
                level = reverseFusionJoin.ingredientOne.level,
                name = reverseFusionJoin.ingredientOne.name,
            ),
            ingredientTwo = FusionIngredient(
                demonId = reverseFusionJoin.ingredientTwo.demonId,
                race = reverseFusionJoin.ingredientTwo.race,
                level = reverseFusionJoin.ingredientTwo.level,
                name = reverseFusionJoin.ingredientTwo.name,
            )
        )
    }

    fun toDomain(reverseFusions: List<ReverseFusionJoin>): List<ReverseFusion> {
        return reverseFusions.map {
            toDomain(it)
        }
    }
}
