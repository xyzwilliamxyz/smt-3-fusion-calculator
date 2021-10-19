package com.think4software.smtfusioncalculator.domain.interactor

import com.think4software.smtfusioncalculator.dao.DemonDao
import com.think4software.smtfusioncalculator.dao.mapper.DemonEvolutionMapper
import com.think4software.smtfusioncalculator.dao.mapper.DemonInheritancesMapper
import com.think4software.smtfusioncalculator.dao.mapper.DemonMapper
import com.think4software.smtfusioncalculator.dao.mapper.DemonResistancesMapper
import com.think4software.smtfusioncalculator.dao.mapper.ForwardFusionMapper
import com.think4software.smtfusioncalculator.dao.mapper.ReverseFusionMapper
import com.think4software.smtfusioncalculator.dao.mapper.SkillMapper
import com.think4software.smtfusioncalculator.infrastructure.BaseTest
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class GetDemonsUseCaseTest: BaseTest() {

    private lateinit var getDemonsUseCase: GetDemonsUseCase

    private val demonDao = mockk<DemonDao>()

    private val demonMapper = DemonMapper(
        demonEvolutionMapper = DemonEvolutionMapper(),
        skillMapper = SkillMapper(),
        demonResistancesMapper = DemonResistancesMapper(),
        demonInheritancesMapper = DemonInheritancesMapper(),
        reverseFusionMapper = ReverseFusionMapper(),
        forwardFusionMapper = ForwardFusionMapper()
    )

    @Before
    fun setup() {
        getDemonsUseCase = GetDemonsUseCase(
            Dispatchers.Unconfined,
            demonDao,
            demonMapper
        )
    }

    @Test
    fun execute_whenCalled_returnsSkillsSuccessfully() {
        coEvery { demonDao.getAll() } coAnswers { listOf(getDemonEntity()) }

        val result = runBlocking { getDemonsUseCase.execute() }

        assertEquals(result.size, 1)
        assertEquals(result[0].demonId, 1)
    }
}
