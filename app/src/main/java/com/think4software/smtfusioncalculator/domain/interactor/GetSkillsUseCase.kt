package com.think4software.smtfusioncalculator.domain.interactor

import com.think4software.smtfusioncalculator.dao.SkillDao
import com.think4software.smtfusioncalculator.dao.mapper.SkillMapper
import com.think4software.smtfusioncalculator.domain.model.Skill
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetSkillsUseCase(
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val skillDao: SkillDao,
    private val skillMapper: SkillMapper
) {
    suspend fun execute(): List<Skill> = withContext(coroutineDispatcher) {
        return@withContext skillMapper.toDomainFromEntity(skillDao.getAll())
    }
}
