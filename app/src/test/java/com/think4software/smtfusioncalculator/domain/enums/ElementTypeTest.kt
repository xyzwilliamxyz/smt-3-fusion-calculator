package com.think4software.smtfusioncalculator.domain.enums

import org.junit.Test
import kotlin.test.assertEquals

class ElementTypeTest {

    @Test
    fun fromId_whenPassingValidValues_convertsDescriptionSuccessfully() {
        assertEquals(ElementType.fromId(0).description, "None")
        assertEquals(ElementType.fromId(1).description, "Physical")
        assertEquals(ElementType.fromId(2).description, "Fire")
        assertEquals(ElementType.fromId(3).description, "Ice")
        assertEquals(ElementType.fromId(4).description, "Thunder")
        assertEquals(ElementType.fromId(5).description, "Wind")
        assertEquals(ElementType.fromId(6).description, "Expel")
        assertEquals(ElementType.fromId(7).description, "Death")
        assertEquals(ElementType.fromId(8).description, "Mind")
        assertEquals(ElementType.fromId(9).description, "Nerve")
        assertEquals(ElementType.fromId(10).description, "Curse")
        assertEquals(ElementType.fromId(11).description, "Passive")
        assertEquals(ElementType.fromId(12).description, "Almighty")
        assertEquals(ElementType.fromId(13).description, "Rec")
        assertEquals(ElementType.fromId(14).description, "Support")
        assertEquals(ElementType.fromId(15).description, "Special")
        assertEquals(ElementType.fromId(16).description, "Talk")
    }

    @Test
    fun fromId_whenInvalidValidValue_convertsToDefaultValueSuccessfully() {
        assertEquals(ElementType.fromId(100).description, "None")
    }
}
