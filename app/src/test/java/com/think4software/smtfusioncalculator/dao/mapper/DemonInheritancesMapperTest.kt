package com.think4software.smtfusioncalculator.dao.mapper

import com.think4software.smtfusioncalculator.infrastructure.BaseTest
import org.junit.Test
import kotlin.test.assertEquals

class DemonInheritancesMapperTest: BaseTest() {

    private val mapper = DemonInheritancesMapper()

    @Test
    fun toDomain_whenDemonEntityPassed_convertsSuccessfully() {
        val demonEntity = getDemonEntity()

        val inheritances = mapper.toDomain(demonEntity)

        assertEquals(inheritances.thrust, demonEntity.inheritThrust)
        assertEquals(inheritances.claw, demonEntity.inheritClaw)
        assertEquals(inheritances.bite, demonEntity.inheritBite)
        assertEquals(inheritances.weapon, demonEntity.inheritWeapon)
        assertEquals(inheritances.mouth, demonEntity.inheritMouth)
        assertEquals(inheritances.wings, demonEntity.inheritWings)
        assertEquals(inheritances.eye, demonEntity.inheritEye)
        assertEquals(inheritances.talk, demonEntity.inheritTalk)
        assertEquals(inheritances.maiden, demonEntity.inheritMaiden)
    }
}
