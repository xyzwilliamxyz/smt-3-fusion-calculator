package com.think4software.smtfusioncalculator.domain.interactor

import com.think4software.smtfusioncalculator.dao.DemonDao
import com.think4software.smtfusioncalculator.dao.mapper.DemonMapper
import com.think4software.smtfusioncalculator.domain.model.Demon
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetDemonDetailsUseCase(
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val demonDao: DemonDao,
    private val demonMapper: DemonMapper
) {
    suspend fun execute(demonId: Int): Demon = withContext(coroutineDispatcher) {
        return@withContext demonMapper.toDomain(demonDao.getDemonWithSkillsAndFusions(demonId))
    }
}
