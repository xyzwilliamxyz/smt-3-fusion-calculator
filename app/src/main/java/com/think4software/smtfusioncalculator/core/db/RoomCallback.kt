package com.think4software.smtfusioncalculator.core.db

import android.content.Context
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import java.io.BufferedReader
import java.io.InputStreamReader

class RoomCallback(
    private val context: Context,
    private val allDataResourceId: Int
): RoomDatabase.Callback() {

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)

        val insertStream = context.resources.openRawResource(allDataResourceId)
        val insertReader = BufferedReader(InputStreamReader(insertStream))

        insertReader.use {
            while (insertReader.ready()) {
                db.execSQL(insertReader.readLine())
            }
        }
    }
}
