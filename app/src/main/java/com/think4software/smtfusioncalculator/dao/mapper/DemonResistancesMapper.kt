package com.think4software.smtfusioncalculator.dao.mapper

import com.think4software.smtfusioncalculator.dao.entity.DemonEntity
import com.think4software.smtfusioncalculator.domain.model.DemonResistances
import com.think4software.smtfusioncalculator.domain.enums.ResistanceType

class DemonResistancesMapper {

    fun toDomain(demonEntity: DemonEntity): DemonResistances {
        return DemonResistances(
            physical = ResistanceType.fromId(demonEntity.resPhysical),
            fire = ResistanceType.fromId(demonEntity.resFire),
            ice = ResistanceType.fromId(demonEntity.resIce),
            electric = ResistanceType.fromId(demonEntity.resThunder),
            force = ResistanceType.fromId(demonEntity.resWind),
            expel = ResistanceType.fromId(demonEntity.resExpel),
            death = ResistanceType.fromId(demonEntity.resDeath),
            mind = ResistanceType.fromId(demonEntity.resMind),
            nerve = ResistanceType.fromId(demonEntity.resNerve),
            curse = ResistanceType.fromId(demonEntity.resCurse),
        )
    }
}
