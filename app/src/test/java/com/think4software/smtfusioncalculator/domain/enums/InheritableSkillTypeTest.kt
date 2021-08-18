package com.think4software.smtfusioncalculator.domain.enums

import org.junit.Test
import kotlin.test.assertEquals

class InheritableSkillTypeTest {

    @Test
    fun fromId_whenPassingValidValues_convertsDescriptionSuccessfully() {
        assertEquals(InheritableSkillType.fromId(0).description, "")
        assertEquals(InheritableSkillType.fromId(1).description, "Thrust")
        assertEquals(InheritableSkillType.fromId(2).description, "Claw")
        assertEquals(InheritableSkillType.fromId(3).description, "Bite")
        assertEquals(InheritableSkillType.fromId(4).description, "Weapon")
        assertEquals(InheritableSkillType.fromId(5).description, "Mouth")
        assertEquals(InheritableSkillType.fromId(6).description, "Wings")
        assertEquals(InheritableSkillType.fromId(7).description, "Eye")
        assertEquals(InheritableSkillType.fromId(8).description, "Talk")
        assertEquals(InheritableSkillType.fromId(9).description, "Maiden")
    }

    @Test
    fun fromId_whenInvalidValidValue_convertsToDefaultValueSuccessfully() {
        assertEquals(InheritableSkillType.fromId(100).description, "")
    }
}