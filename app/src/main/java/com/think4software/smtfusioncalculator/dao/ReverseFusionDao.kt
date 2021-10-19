package com.think4software.smtfusioncalculator.dao

import androidx.room.Dao
import androidx.room.Query
import com.think4software.smtfusioncalculator.dao.entity.ReverseFusionEntity

@Dao
interface ReverseFusionDao {

    @Query("SELECT * FROM reverse_demon_fusion")
    suspend fun getAll(): List<ReverseFusionEntity>
}
