package com.think4software.smtfusioncalculator.domain.enums

import org.junit.Test
import kotlin.test.assertEquals

class ResistanceTypeTest {

    @Test
    fun fromId_whenPassingValidValues_convertsDescriptionSuccessfully() {
        assertEquals(ResistanceType.fromId(0).description, "")
        assertEquals(ResistanceType.fromId(1).description, "Null")
        assertEquals(ResistanceType.fromId(2).description, "Weak")
        assertEquals(ResistanceType.fromId(3).description, "Strong")
        assertEquals(ResistanceType.fromId(4).description, "Repel")
        assertEquals(ResistanceType.fromId(5).description, "Absorb")
    }

    @Test
    fun fromId_whenPassingValidValues_convertsAbbreviationSuccessfully() {
        assertEquals(ResistanceType.fromId(0).abbreviation, "")
        assertEquals(ResistanceType.fromId(1).abbreviation, "nu")
        assertEquals(ResistanceType.fromId(2).abbreviation, "wk")
        assertEquals(ResistanceType.fromId(3).abbreviation, "rs")
        assertEquals(ResistanceType.fromId(4).abbreviation, "rp")
        assertEquals(ResistanceType.fromId(5).abbreviation, "ab")
    }

    @Test
    fun fromId_whenInvalidValidValue_convertsToDefaultValueSuccessfully() {
        assertEquals(ResistanceType.fromId(100).description, "")
    }
}