package com.think4software.smtfusioncalculator.dao.join

import androidx.room.Embedded
import androidx.room.Relation
import com.think4software.smtfusioncalculator.dao.entity.DemonEntity
import com.think4software.smtfusioncalculator.dao.entity.DemonSkillEntity

data class DemonAndDemonSkillsJoin(
    @Embedded val demon: DemonEntity,
    @Relation(
        parentColumn = "demon_id",
        entityColumn = "demon_id",
        entity = DemonSkillEntity::class
    )
    val demonSkills: List<DemonSkillAndSkillJoin>,

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
