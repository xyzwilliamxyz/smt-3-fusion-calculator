package com.think4software.smtfusioncalculator.dao.mapper

import com.think4software.smtfusioncalculator.dao.entity.DemonEntity
import com.think4software.smtfusioncalculator.factory.DemonFactory.getDemonAndDemonSkillsAndDemonFusionsJoin
import com.think4software.smtfusioncalculator.factory.DemonFactory.getDemonEntity
import org.junit.Test
import kotlin.test.assertEquals

class DemonMapperTest {

    private val mapper = DemonMapper(
        demonEvolutionMapper = DemonEvolutionMapper(),
        skillMapper = SkillMapper(),
        demonResistancesMapper = DemonResistancesMapper(),
        demonInheritancesMapper = DemonInheritancesMapper(),
        reverseFusionMapper = ReverseFusionMapper(),
        forwardFusionMapper = ForwardFusionMapper()
    )

    @Test
    fun toDomain_whenDemonEntityPassed_convertsSuccessfully() {
        val demonEntity = getDemonEntity()

        val demon = mapper.toDomain(demonEntity)

        assertEquals(demonEntity.demonId, demon.demonId)
        assertEquals(demonEntity.name, demon.name)
        assertEquals(demonEntity.level, demon.level)
        assertEquals(demonEntity.race, demon.race)
        assertEquals(demonEntity.price, demon.price)
        assertEquals(demonEntity.hp, demon.hp)
        assertEquals(demonEntity.mp, demon.mp)
        assertEquals(demonEntity.strength, demon.strength)
        assertEquals(demonEntity.magic, demon.magic)
        assertEquals(demonEntity.vitality, demon.vitality)
        assertEquals(demonEntity.agility, demon.agility)
        assertEquals(demonEntity.luck, demon.luck)
        assertEquals(demonEntity.specialFusionCondition, demon.specialFusionCondition)
    }

    @Test
    fun toDomain_whenDemonEntityListPassed_convertsSuccessfully() {
        val demonEntities = mutableListOf<DemonEntity>().apply {
            repeat(5) { add(getDemonEntity()) }
        }

        val demons = mapper.toDomain(demonEntities)

        assertEquals(demonEntities.size, demons.size)
    }

    @Test
    fun toDomain_whenDemonJoinPassed_convertsSuccessfully() {
        val demonJoin = getDemonAndDemonSkillsAndDemonFusionsJoin()

        val demon = mapper.toDomain(demonJoin)

        assertEquals(demonJoin.evolvesFrom!!.demonId, demon.evolvesFrom!!.demonId)
        assertEquals(demonJoin.evolvesTo!!.demonId, demon.evolvesTo!!.demonId)
        assertEquals(demonJoin.forwardFusions[0].result.demonId, demon.forwardFusions[0].result.demonId)
        assertEquals(demonJoin.reverseFusions[0].ingredientOne.demonId, demon.reverseFusions[0].ingredientOne.demonId)
    }
}
