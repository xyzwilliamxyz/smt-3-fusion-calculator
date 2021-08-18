package com.think4software.smtfusioncalculator.dao.mapper

import com.think4software.smtfusioncalculator.infrastructure.BaseTest
import kotlin.test.Test
import kotlin.test.assertEquals


class DemonEvolutionMapperTest: BaseTest() {

    private val mapper = DemonEvolutionMapper()

    @Test
    fun toDomain_whenThereIsEvolution_convertsSuccessfully() {
        val demonEntity = getDemonEntity()

        val demonEvolution = mapper.toDomain(demonEntity, 5)

        assertEquals(demonEvolution!!.demonId, demonEntity.demonId)
        assertEquals(demonEvolution.level, 5)
        assertEquals(demonEvolution.name, demonEntity.name)
    }

    @Test
    fun toDomain_whenThereIsNoEvolution_convertsToNull() {
        val demonEvolution = mapper.toDomain(null, 0)

        assertEquals(demonEvolution, null)
    }
}