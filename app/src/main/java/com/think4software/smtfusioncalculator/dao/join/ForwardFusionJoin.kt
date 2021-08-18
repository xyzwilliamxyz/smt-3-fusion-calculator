package com.think4software.smtfusioncalculator.dao.join

import androidx.room.Embedded
import androidx.room.Relation
import com.think4software.smtfusioncalculator.dao.entity.DemonEntity
import com.think4software.smtfusioncalculator.dao.entity.ForwardFusionEntity

data class ForwardFusionJoin(
    @Embedded
    val forwardFusion: ForwardFusionEntity,
    @Relation(
        parentColumn = "ingredient_two",
        entityColumn = "demon_id",
        entity = DemonEntity::class
    )
    val ingredientTwo: DemonEntity,
    @Relation(
        parentColumn = "result",
        entityColumn = "demon_id",
        entity = DemonEntity::class
    )
    val result: DemonEntity,
)