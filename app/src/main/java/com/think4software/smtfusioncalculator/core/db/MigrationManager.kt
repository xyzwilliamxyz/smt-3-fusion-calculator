package com.think4software.smtfusioncalculator.core.db

import androidx.room.migration.Migration

class MigrationManager(
    private val migrationFactory: MigrationFactory,
    private val allDataResourceId: Int) {

    fun getMigrations(): Array<Migration> {
        return arrayOf(
            migrationFactory.getMigration(1, 2, allDataResourceId)
        )
    }
}
