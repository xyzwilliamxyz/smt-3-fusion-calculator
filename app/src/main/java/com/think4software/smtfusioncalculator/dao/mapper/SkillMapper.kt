package com.think4software.smtfusioncalculator.dao.mapper

import androidx.annotation.VisibleForTesting
import com.think4software.smtfusioncalculator.dao.entity.SkillEntity
import com.think4software.smtfusioncalculator.dao.join.DemonSkillAndSkillJoin
import com.think4software.smtfusioncalculator.domain.enums.ElementType
import com.think4software.smtfusioncalculator.domain.enums.InheritableSkillType
import com.think4software.smtfusioncalculator.domain.model.Skill

class SkillMapper {

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    fun toDomain(skillEntity: SkillEntity): Skill {
        return Skill(
            skillId = skillEntity.skillId,
            name = skillEntity.name,
            element = ElementType.fromId(skillEntity.element),
            cost = skillEntity.cost.replace(AUTO, NONE),
            effect = skillEntity.effect,
            target = skillEntity.target,
            rank = skillEntity.rank,
            inherit = InheritableSkillType.fromId(skillEntity.inherit),
            unique = skillEntity.unique,
        )
    }

    fun toDomainFromEntity(skillsEntity: List<SkillEntity>): List<Skill> {
        return skillsEntity.map {
            toDomain(it)
        }
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    fun toDomain(skillJoin: DemonSkillAndSkillJoin): Skill {
        return toDomain(skillJoin.skill).also {
            it.level = parseLevel(skillJoin.demonSkill.level)
        }
    }

    fun toDomain(skillsJoin: List<DemonSkillAndSkillJoin>): List<Skill> {
        return skillsJoin.map {
            toDomain(it)
        }
    }

    private fun parseLevel(level: Int): String {
        return if (level == 0) NONE else level.toString()
    }

    companion object {
        private const val AUTO = "auto"
        private const val NONE = "-"
    }
}
