package com.think4software.smtfusioncalculator.dao

import androidx.room.Dao
import androidx.room.Query
import com.think4software.smtfusioncalculator.dao.entity.ForwardFusionEntity

@Dao
interface ForwardFusionDao {

    @Query("SELECT * FROM forward_demon_fusion")
    suspend fun getAll(): List<ForwardFusionEntity>
}