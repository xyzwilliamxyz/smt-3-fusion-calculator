package com.think4software.smtfusioncalculator.dao.mapper

import com.think4software.smtfusioncalculator.dao.join.ForwardFusionJoin
import com.think4software.smtfusioncalculator.infrastructure.BaseTest
import org.junit.Test
import kotlin.test.assertEquals

class ForwardFusionMapperTest: BaseTest() {

    private val mapper = ForwardFusionMapper()

    @Test
    fun toDomain_whenForwardFusionPassed_convertsSuccessfully() {
        val forwardFusionJoin = getForwardFusionJoin()

        val forwardFusion = mapper.toDomain(forwardFusionJoin)

        assertEquals(forwardFusionJoin.ingredientTwo.demonId, forwardFusion.ingredientTwo.demonId)
        assertEquals(forwardFusionJoin.ingredientTwo.race, forwardFusion.ingredientTwo.race)
        assertEquals(forwardFusionJoin.ingredientTwo.level, forwardFusion.ingredientTwo.level)
        assertEquals(forwardFusionJoin.ingredientTwo.name, forwardFusion.ingredientTwo.name)
        assertEquals(forwardFusionJoin.result.demonId, forwardFusion.result.demonId)
        assertEquals(forwardFusionJoin.result.race, forwardFusion.result.race)
        assertEquals(forwardFusionJoin.result.level, forwardFusion.result.level)
        assertEquals(forwardFusionJoin.result.name, forwardFusion.result.name)
    }

    @Test
    fun toDomain_whenForwardFusionListPassed_convertsSuccessfully() {
        val forwardFusionJoins = mutableListOf<ForwardFusionJoin>().apply {
            repeat(5) { add(getForwardFusionJoin()) }
        }

        val forwardFusions = mapper.toDomain(forwardFusionJoins)

        assertEquals(forwardFusionJoins.size, forwardFusions.size)
    }
}
