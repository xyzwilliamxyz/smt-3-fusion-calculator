package com.think4software.smtfusioncalculator.dao.mapper

import com.think4software.smtfusioncalculator.dao.entity.SkillEntity
import com.think4software.smtfusioncalculator.domain.enums.ElementType
import com.think4software.smtfusioncalculator.domain.enums.InheritableSkillType
import com.think4software.smtfusioncalculator.infrastructure.BaseTest
import org.junit.Test
import kotlin.test.assertEquals

class SkillMapperTest: BaseTest() {

    private val mapper = SkillMapper()

    @Test
    fun toDomain_whenSkillEntityPassed_convertsSuccessfully() {
        val skillEntity = getSkillEntity()

        val skill = mapper.toDomain(skillEntity)

        assertEquals(skillEntity.skillId, skill.skillId)
        assertEquals(skillEntity.name, skill.name)
        assertEquals(ElementType.fromId(skillEntity.element), skill.element)
        assertEquals(skillEntity.cost, skill.cost)
        assertEquals(skillEntity.effect, skill.effect)
        assertEquals(skillEntity.target, skill.target)
        assertEquals(skillEntity.rank, skill.rank)
        assertEquals(InheritableSkillType.fromId(skillEntity.inherit), skill.inherit)
        assertEquals(skillEntity.unique, skill.unique)
    }

    @Test
    fun toDomain_whenSkillEntityWithoutCostPassed_convertsSuccessfully() {
        val skillEntity = getSkillEntity("auto")

        val skill = mapper.toDomain(skillEntity)

        assertEquals("-", skill.cost)
    }

    @Test
    fun toDomainFromEntity_whenSkillListPassed_convertsSuccessfully() {
        val skillEntities = mutableListOf<SkillEntity>().apply {
            repeat(5) { add(getSkillEntity()) }
        }

        val skills = mapper.toDomainFromEntity(skillEntities)

        assertEquals(skillEntities.size, skills.size)
    }

    @Test
    fun toDomain_whenDemonSkillWithLevelPassed_convertsSuccessfully() {
        val demonSkillJoin = getDemonSkillAndSkillJoin()

        val skill = mapper.toDomain(demonSkillJoin)

        assertEquals("10", skill.level)
    }

    @Test
    fun toDomain_whenDemonSkillWithoutLevelPassed_convertsSuccessfully() {
        val demonSkillJoin = getDemonSkillAndSkillJoin(0)

        val skill = mapper.toDomain(demonSkillJoin)

        assertEquals("-", skill.level)
    }
}