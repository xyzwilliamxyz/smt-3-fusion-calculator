package com.think4software.smtfusioncalculator

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.karumi.shot.ScreenshotTest
import com.think4software.smtfusioncalculator.core.db.AppDatabase
import com.think4software.smtfusioncalculator.test.R
import com.think4software.smtfusioncalculator.utils.InMemoryDatabaseBuilder
import org.junit.Before
import org.junit.Rule
import org.junit.rules.TestName
import org.junit.runner.RunWith
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

@RunWith(AndroidJUnit4::class)
abstract class BaseInstrumentedTest: ScreenshotTest {

    @Before
    fun setup() {
        loadKoinModules(
            module {
                factory { InMemoryDatabaseBuilder.getDatabaseBuilder(context = androidContext()) }

                single {
                    AppDatabase.createDatabase(
                        context = InstrumentationRegistry.getInstrumentation().context,
                        databaseBuilder = get(),
                        resourceId = R.raw.smt3_test_data
                    )
                }
            }
        )
    }
}