package com.think4software.smtfusioncalculator.dao.mapper

import com.think4software.smtfusioncalculator.dao.entity.DemonEntity
import com.think4software.smtfusioncalculator.domain.model.DemonInheritances

class DemonInheritancesMapper {

    fun toDomain(demonEntity: DemonEntity): DemonInheritances {
        return DemonInheritances(
            thrust = demonEntity.inheritThrust,
            claw = demonEntity.inheritClaw,
            bite = demonEntity.inheritBite,
            weapon = demonEntity.inheritWeapon,
            mouth = demonEntity.inheritMouth,
            wings = demonEntity.inheritWings,
            eye = demonEntity.inheritEye,
            talk = demonEntity.inheritTalk,
            maiden = demonEntity.inheritMaiden,
        )
    }
}