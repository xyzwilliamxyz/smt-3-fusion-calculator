package com.think4software.smtfusioncalculator.dao.join

import androidx.room.Embedded
import androidx.room.Relation
import com.think4software.smtfusioncalculator.dao.entity.DemonSkillEntity
import com.think4software.smtfusioncalculator.dao.entity.SkillEntity

data class DemonSkillAndSkillJoin(
    @Embedded val demonSkill: DemonSkillEntity,
    @Relation(
        parentColumn = "skill_id",
        entityColumn = "skill_id",
        entity = SkillEntity::class
    )
    val skill: SkillEntity
)
