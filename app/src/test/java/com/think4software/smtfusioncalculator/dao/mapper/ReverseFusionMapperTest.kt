package com.think4software.smtfusioncalculator.dao.mapper

import com.think4software.smtfusioncalculator.dao.join.ReverseFusionJoin
import com.think4software.smtfusioncalculator.factory.DemonFactory.getReverseFusionJoin
import org.junit.Test
import kotlin.test.assertEquals


class ReverseFusionMapperTest {

    private val mapper = ReverseFusionMapper()

    @Test
    fun toDomain_whenReverseFusionPassed_convertsSuccessfully() {
        val reverseFusionJoin = getReverseFusionJoin()

        val reverseFusion = mapper.toDomain(reverseFusionJoin)

        assertEquals(reverseFusionJoin.ingredientOne.demonId, reverseFusion.ingredientOne.demonId)
        assertEquals(reverseFusionJoin.ingredientOne.race, reverseFusion.ingredientOne.race)
        assertEquals(reverseFusionJoin.ingredientOne.level, reverseFusion.ingredientOne.level)
        assertEquals(reverseFusionJoin.ingredientOne.name, reverseFusion.ingredientOne.name)
        assertEquals(reverseFusionJoin.ingredientTwo.demonId, reverseFusion.ingredientTwo.demonId)
        assertEquals(reverseFusionJoin.ingredientTwo.race, reverseFusion.ingredientTwo.race)
        assertEquals(reverseFusionJoin.ingredientTwo.level, reverseFusion.ingredientTwo.level)
        assertEquals(reverseFusionJoin.ingredientTwo.name, reverseFusion.ingredientTwo.name)
    }

    @Test
    fun toDomain_whenReverseFusionListPassed_convertsSuccessfully() {
        val reverseFusionJoins = mutableListOf<ReverseFusionJoin>().apply {
            repeat(5) { add(getReverseFusionJoin()) }
        }

        val reverseFusions = mapper.toDomain(reverseFusionJoins)

        assertEquals(reverseFusionJoins.size, reverseFusions.size)
    }
}
