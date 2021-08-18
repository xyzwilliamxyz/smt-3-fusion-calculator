package com.think4software.smtfusioncalculator.core.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.think4software.smtfusioncalculator.core.Constants

abstract class DatabaseBuilder {
    companion object {
        fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<AppDatabase> {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                Constants.DATABASE_NAME
            )
        }
    }
}