package com.think4software.smtfusioncalculator.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.think4software.smtfusioncalculator.dao.entity.DemonEntity
import com.think4software.smtfusioncalculator.dao.join.DemonAndDemonSkillsAndDemonFusionsJoin

@Dao
interface DemonDao {

    @Query("SELECT * FROM demon")
    suspend fun getAll(): List<DemonEntity>

    @Transaction
    @Query("SELECT * FROM demon")
    suspend fun getAllWithSkillsAndFusions(): List<DemonAndDemonSkillsAndDemonFusionsJoin>

    @Transaction
    @Query("SELECT * FROM demon WHERE demon_id = :demonId")
    suspend fun getDemonWithSkillsAndFusions(demonId: Int): DemonAndDemonSkillsAndDemonFusionsJoin
}