package com.think4software.smtfusioncalculator.domain.enums

enum class InheritableSkillType(val id: Int, val description: String) {
    NONE(0, ""),
    THRUST(1, "Thrust"),
    CLAW(2, "Claw"),
    BITE(3, "Bite"),
    WEAPON(4, "Weapon"),
    MOUTH(5, "Mouth"),
    WINGS(6, "Wings"),
    EYE(7, "Eye"),
    TALK(8, "Talk"),
    MAIDEN(9, "Maiden");

    companion object {
        private val map = values().associateBy(InheritableSkillType::id)

        fun fromId(id: Int) = map[id] ?: NONE
    }
}
