package com.think4software.smtfusioncalculator.core.db

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
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
import org.koin.core.component.KoinComponent

@Database(entities = [
    SkillEntity::class,
    DemonEntity::class,
    DemonSkillEntity::class,
    ReverseFusionEntity::class,
    ForwardFusionEntity::class,
],
version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase(), KoinComponent {
    abstract fun skillDao(): SkillDao
    abstract fun demonDao(): DemonDao
    abstract fun demonSkillDao(): DemonSkillDao
    abstract fun reverseFusionDao(): ReverseFusionDao
    abstract fun forwardFusionDao(): ForwardFusionDao

    companion object: KoinComponent {
        fun createDatabase(
            context: Context,
            databaseBuilder: Builder<AppDatabase>,
            allDataResourceId: Int,
            migrationManager: MigrationManager
        ): AppDatabase {
            return databaseBuilder
                .addCallback(RoomCallback(context, allDataResourceId))
                .addMigrations(
                    *migrationManager.getMigrations()
                )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}