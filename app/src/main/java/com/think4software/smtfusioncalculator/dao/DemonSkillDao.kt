package com.think4software.smtfusioncalculator.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.think4software.smtfusioncalculator.dao.entity.SkillEntity
import com.think4software.smtfusioncalculator.dao.join.DemonSkillAndSkillJoin

@Dao
interface DemonSkillDao {

    @Transaction
    @Query("SELECT * FROM demon_skill")
    suspend fun getAll(): List<DemonSkillAndSkillJoin>
}
