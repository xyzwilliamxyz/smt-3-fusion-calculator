package com.think4software.smtfusioncalculator.di

import com.think4software.smtfusioncalculator.R
import com.think4software.smtfusioncalculator.core.db.AppDatabase
import com.think4software.smtfusioncalculator.core.db.DatabaseBuilder
import com.think4software.smtfusioncalculator.core.db.MigrationFactory
import com.think4software.smtfusioncalculator.core.db.MigrationManager
import com.think4software.smtfusioncalculator.dao.mapper.DemonEvolutionMapper
import com.think4software.smtfusioncalculator.dao.mapper.DemonInheritancesMapper
import com.think4software.smtfusioncalculator.dao.mapper.DemonMapper
import com.think4software.smtfusioncalculator.dao.mapper.DemonResistancesMapper
import com.think4software.smtfusioncalculator.dao.mapper.ForwardFusionMapper
import com.think4software.smtfusioncalculator.dao.mapper.ReverseFusionMapper
import com.think4software.smtfusioncalculator.dao.mapper.SkillMapper
import com.think4software.smtfusioncalculator.domain.interactor.GetDemonDetailsUseCase
import com.think4software.smtfusioncalculator.domain.interactor.GetDemonsUseCase
import com.think4software.smtfusioncalculator.domain.interactor.GetSkillsUseCase
import com.think4software.smtfusioncalculator.ui.demondetails.DemonDetailsViewModel
import com.think4software.smtfusioncalculator.ui.demonlist.DemonListViewModel
import com.think4software.smtfusioncalculator.ui.skilllist.SkillListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {
    viewModel { DemonListViewModel(getDemonsUseCase = get()) }
    viewModel { DemonDetailsViewModel(getDemonDetailsUseCase = get()) }
    viewModel { SkillListViewModel(getSkillsUseCase = get()) }
}

val useCaseModules = module {
    factory { GetDemonsUseCase(demonDao = get(), demonMapper = get()) }
    factory { GetDemonDetailsUseCase(demonDao = get(), demonMapper = get()) }
    factory { GetSkillsUseCase(skillDao = get(), skillMapper = get()) }
}

val databaseModules = module {
    factory { DatabaseBuilder.getDatabaseBuilder(context = androidContext()) }
    factory { MigrationFactory(context = get()) }
    factory { MigrationManager(migrationFactory = get(), allDataResourceId = R.raw.smt3_data) }

    single {
        AppDatabase.createDatabase(
            context = androidContext(),
            databaseBuilder = get(),
            allDataResourceId = R.raw.smt3_data,
            migrationManager = get()
        )
    }

    factory { get<AppDatabase>().demonDao() }
    factory { get<AppDatabase>().skillDao() }
    factory { get<AppDatabase>().demonSkillDao() }
    factory { get<AppDatabase>().reverseFusionDao() }
    factory { get<AppDatabase>().forwardFusionDao() }

    factory {
        DemonMapper(
            demonEvolutionMapper = get(),
            skillMapper = get(),
            demonResistancesMapper = get(),
            demonInheritancesMapper = get(),
            reverseFusionMapper = get(),
            forwardFusionMapper = get()
        )
    }
    factory { DemonEvolutionMapper() }
    factory { DemonInheritancesMapper() }
    factory { DemonResistancesMapper() }
    factory { ForwardFusionMapper() }
    factory { ReverseFusionMapper() }
    factory { SkillMapper() }
}
