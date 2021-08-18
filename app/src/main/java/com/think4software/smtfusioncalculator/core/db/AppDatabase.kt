package com.think4software.smtfusioncalculator.core.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.think4software.smtfusioncalculator.core.Constants
import com.think4software.smtfusioncalculator.dao.DemonDao
import com.think4software.smtfusioncalculator.dao.DemonSkillDao
import com.think4software.smtfusioncalculator.dao.ForwardFusionDao
import com.think4software.smtfusioncalculator.dao.ReverseFusionDao
import com.think4software.smtfusioncalculator.dao.SkillDao
import com.think4software.smtfusioncalculator.dao.entity.DemonEntity
import com.think4software.smtfusioncalculator.dao.entity.DemonSkillEntity
import com.think4software.smtfusioncalculator.dao.entity.ForwardFusionEntity
import com.think4software.smtfusioncalculator.dao.entity.ReverseFusionEntity
import com.think4software.smtfusioncalculator.dao.entity.SkillEntity

@Database(entities = [
    SkillEntity::class,
    DemonEntity::class,
    DemonSkillEntity::class,
    ReverseFusionEntity::class,
    ForwardFusionEntity::class,
], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun skillDao(): SkillDao
    abstract fun demonDao(): DemonDao
    abstract fun demonSkillDao(): DemonSkillDao
    abstract fun reverseFusionDao(): ReverseFusionDao
    abstract fun forwardFusionDao(): ForwardFusionDao

    companion object {
        fun createDatabase(context: Context, databaseBuilder: Builder<AppDatabase>, resourceId: Int): AppDatabase {
            return databaseBuilder
                .addCallback(RoomCallback(context, resourceId))
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}