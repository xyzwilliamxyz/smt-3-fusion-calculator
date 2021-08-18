package com.think4software.smtfusioncalculator.utils

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.think4software.smtfusioncalculator.core.db.AppDatabase

abstract class InMemoryDatabaseBuilder {
    companion object {
        fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<AppDatabase> {
            return Room.inMemoryDatabaseBuilder(
                context,
                AppDatabase::class.java
            )
        }
    }
}