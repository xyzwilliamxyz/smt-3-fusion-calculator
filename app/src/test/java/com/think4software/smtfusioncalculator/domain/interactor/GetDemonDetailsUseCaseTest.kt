package com.think4software.smtfusioncalculator.domain.interactor

import com.think4software.smtfusioncalculator.dao.DemonDao
import com.think4software.smtfusioncalculator.dao.mapper.DemonEvolutionMapper
import com.think4software.smtfusioncalculator.dao.mapper.DemonInheritancesMapper
import com.think4software.smtfusioncalculator.dao.mapper.DemonMapper
import com.think4software.smtfusioncalculator.dao.mapper.DemonResistancesMapper
import com.think4software.smtfusioncalculator.dao.mapper.ForwardFusionMapper
import com.think4software.smtfusioncalculator.dao.mapper.ReverseFusionMapper
import com.think4software.smtfusioncalculator.dao.mapper.SkillMapper
import com.think4software.smtfusioncalculator.factory.DemonFactory.getDemonAndDemonSkillsAndDemonFusionsJoin
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class GetDemonDetailsUseCaseTest {

    private lateinit var getDemonDetailsUseCase: GetDemonDetailsUseCase

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
        getDemonDetailsUseCase = GetDemonDetailsUseCase(
            Dispatchers.Unconfined,
            demonDao,
            demonMapper
        )
    }

    @Test
    fun execute_whenCalled_returnsSkillsSuccessfully() {
        coEvery { demonDao.getDemonWithSkillsAndFusions(1) } coAnswers {
            getDemonAndDemonSkillsAndDemonFusionsJoin()
        }

        val result = runBlocking { getDemonDetailsUseCase.execute(1) }

        assertEquals(result.demonId, 1)
        assertEquals(result.name, "Jack Frost")
    }
}
