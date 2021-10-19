package com.think4software.smtfusioncalculator.dao.join

import androidx.room.Embedded
import androidx.room.Relation
import com.think4software.smtfusioncalculator.dao.entity.DemonEntity
import com.think4software.smtfusioncalculator.dao.entity.ReverseFusionEntity
import com.think4software.smtfusioncalculator.dao.entity.DemonSkillEntity
import com.think4software.smtfusioncalculator.dao.entity.ForwardFusionEntity

data class DemonAndDemonSkillsAndDemonFusionsJoin(
    @Embedded val demon: DemonEntity,
    @Relation(
        parentColumn = "demon_id",
        entityColumn = "demon_id",
        entity = DemonSkillEntity::class
    )
    val demonSkills: List<DemonSkillAndSkillJoin>,
    @Relation(
        parentColumn = "demon_id",
        entityColumn = "demon_id",
        entity = ReverseFusionEntity::class
    )
    val reverseFusions: List<ReverseFusionJoin>,
    @Relation(
        parentColumn = "demon_id",
        entityColumn = "demon_id",
        entity = ForwardFusionEntity::class
    )
    val forwardFusions: List<ForwardFusionJoin>,
    @Relation(
        parentColumn = "evolves_from",
        entityColumn = "demon_id",
        entity = DemonEntity::class
    )
    val evolvesFrom: DemonEntity?,
    @Relation(
        parentColumn = "evolves_to",
        entityColumn = "demon_id",
        entity = DemonEntity::class
    )
    val evolvesTo: DemonEntity?,
)
