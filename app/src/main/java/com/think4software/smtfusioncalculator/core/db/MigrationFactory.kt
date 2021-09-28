package com.think4software.smtfusioncalculator.core.db

import android.content.Context
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import java.io.BufferedReader
import java.io.InputStreamReader

class MigrationFactory(val context: Context) {

    fun getMigration(startVersion: Int, endVersion: Int, resourceId: Int): Migration {
        return SimpleMigration(startVersion, endVersion, context, resourceId)
    }

    private class SimpleMigration(
        startVersion: Int,
        endVersion: Int,
        val context: Context,
        val resourceId: Int
    ): Migration(startVersion, endVersion) {
        override fun migrate(database: SupportSQLiteDatabase) {
            val insertStream = context.resources.openRawResource(resourceId)
            val insertReader = BufferedReader(InputStreamReader(insertStream))

            insertReader.use {
                while (insertReader.ready()) {
                    database.execSQL(insertReader.readLine())
                }
            }
        }
    }
}

