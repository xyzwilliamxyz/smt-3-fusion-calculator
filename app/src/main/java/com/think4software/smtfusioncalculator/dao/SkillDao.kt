package com.think4software.smtfusioncalculator.dao

import androidx.room.Dao
import androidx.room.Query
import com.think4software.smtfusioncalculator.dao.entity.SkillEntity

@Dao
interface SkillDao {

    @Query("SELECT * FROM skill")
    suspend fun getAll(): List<SkillEntity>
}
