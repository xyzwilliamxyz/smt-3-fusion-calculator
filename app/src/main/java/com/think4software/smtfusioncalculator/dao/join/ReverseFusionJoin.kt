package com.think4software.smtfusioncalculator.dao.join

import androidx.room.Embedded
import androidx.room.Relation
import com.think4software.smtfusioncalculator.dao.entity.DemonEntity
import com.think4software.smtfusioncalculator.dao.entity.ReverseFusionEntity

data class ReverseFusionJoin(
    @Embedded
    val reverseFusion: ReverseFusionEntity,
    @Relation(
        parentColumn = "ingredient_one",
        entityColumn = "demon_id",
        entity = DemonEntity::class
    )
    val ingredientOne: DemonEntity,
    @Relation(
        parentColumn = "ingredient_two",
        entityColumn = "demon_id",
        entity = DemonEntity::class
    )
    val ingredientTwo: DemonEntity,
)