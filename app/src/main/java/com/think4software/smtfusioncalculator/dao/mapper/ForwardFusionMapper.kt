package com.think4software.smtfusioncalculator.dao.mapper

import androidx.annotation.VisibleForTesting
import com.think4software.smtfusioncalculator.dao.join.ForwardFusionJoin
import com.think4software.smtfusioncalculator.domain.model.ForwardFusion
import com.think4software.smtfusioncalculator.domain.model.FusionIngredient

class ForwardFusionMapper {

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    fun toDomain(forwardFusionJoin: ForwardFusionJoin): ForwardFusion {
        return ForwardFusion(
            ingredientTwo = FusionIngredient(
                demonId = forwardFusionJoin.ingredientTwo.demonId,
                race = forwardFusionJoin.ingredientTwo.race,
                level = forwardFusionJoin.ingredientTwo.level,
                name = forwardFusionJoin.ingredientTwo.name,
            ),
            result = FusionIngredient(
                demonId = forwardFusionJoin.result.demonId,
                race = forwardFusionJoin.result.race,
                level = forwardFusionJoin.result.level,
                name = forwardFusionJoin.result.name,
            )
        )
    }

    fun toDomain(forwardFusions: List<ForwardFusionJoin>): List<ForwardFusion> {
        return forwardFusions.map {
            toDomain(it)
        }
    }
}
