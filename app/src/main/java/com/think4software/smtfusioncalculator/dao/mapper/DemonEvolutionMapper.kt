package com.think4software.smtfusioncalculator.dao.mapper

import com.think4software.smtfusioncalculator.dao.entity.DemonEntity
import com.think4software.smtfusioncalculator.domain.model.DemonEvolution

class DemonEvolutionMapper {

    fun toDomain(demonEntity: DemonEntity?, evolvesLevel: Int): DemonEvolution? {
        return demonEntity?.let {
            DemonEvolution(
                demonId = it.demonId,
                race = it.race,
                level = evolvesLevel,
                name = it.name
            )
        }
    }
}