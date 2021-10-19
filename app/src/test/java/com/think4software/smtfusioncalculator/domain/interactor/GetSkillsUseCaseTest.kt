package com.think4software.smtfusioncalculator.domain.interactor

import com.think4software.smtfusioncalculator.dao.SkillDao
import com.think4software.smtfusioncalculator.dao.mapper.SkillMapper
import com.think4software.smtfusioncalculator.factory.DemonFactory.getSkillEntity
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class GetSkillsUseCaseTest {

    private lateinit var getSkillsUseCase: GetSkillsUseCase

    private val skillDao = mockk<SkillDao>()

    @Before
    fun setup() {
        getSkillsUseCase = GetSkillsUseCase(
            Dispatchers.Unconfined,
            skillDao,
            SkillMapper()
        )
    }

    @Test
    fun execute_whenCalled_returnsSkillsSuccessfully() {
        coEvery { skillDao.getAll() } coAnswers { listOf(getSkillEntity()) }

        val result = runBlocking { getSkillsUseCase.execute() }

        assertEquals(result.size, 1)
        assertEquals(result[0].skillId, 10)
    }
}
