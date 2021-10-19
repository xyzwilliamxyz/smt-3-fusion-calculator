package com.think4software.smtfusioncalculator.domain.enums

enum class ResistanceType(val id: Int, val description: String, val abbreviation: String) {
    NONE(0, "", ""),
    NULL(1, "Null", "nu"),
    WEAK(2, "Weak", "wk"),
    STRONG(3, "Strong", "rs"),
    REPEL(4, "Repel", "rp"),
    ABSORB(5, "Absorb", "ab");

    companion object {
        private val map = values().associateBy(ResistanceType::id)

        fun fromId(id: Int) = map[id] ?: NONE
    }
}
