package com.think4software.smtfusioncalculator.dao.mapper

import com.think4software.smtfusioncalculator.domain.enums.ResistanceType
import com.think4software.smtfusioncalculator.factory.DemonFactory.getDemonEntity
import org.junit.Test
import kotlin.test.assertEquals

class DemonResistancesMapperTest {

    private val mapper = DemonResistancesMapper()

    @Test
    fun toDomain_whenDemonEntityPassed_convertsSuccessfully() {
        val demonEntity = getDemonEntity()

        val resistances = mapper.toDomain(demonEntity)

        assertEquals(resistances.physical, ResistanceType.fromId(demonEntity.resPhysical))
        assertEquals(resistances.fire, ResistanceType.fromId(demonEntity.resFire))
        assertEquals(resistances.ice, ResistanceType.fromId(demonEntity.resIce))
        assertEquals(resistances.electric, ResistanceType.fromId(demonEntity.resThunder))
        assertEquals(resistances.force, ResistanceType.fromId(demonEntity.resWind))
        assertEquals(resistances.expel, ResistanceType.fromId(demonEntity.resExpel))
        assertEquals(resistances.death, ResistanceType.fromId(demonEntity.resDeath))
        assertEquals(resistances.mind, ResistanceType.fromId(demonEntity.resMind))
        assertEquals(resistances.nerve, ResistanceType.fromId(demonEntity.resNerve))
        assertEquals(resistances.curse, ResistanceType.fromId(demonEntity.resCurse))
    }
}
