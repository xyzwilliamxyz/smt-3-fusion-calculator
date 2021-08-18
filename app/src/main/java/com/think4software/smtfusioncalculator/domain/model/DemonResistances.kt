package com.think4software.smtfusioncalculator.domain.model

import com.think4software.smtfusioncalculator.domain.enums.ResistanceType

data class DemonResistances(
    val physical: ResistanceType,
    val fire: ResistanceType,
    val ice: ResistanceType,
    val electric: ResistanceType,
    val force: ResistanceType,
    val expel: ResistanceType,
    val death: ResistanceType,
    val mind: ResistanceType,
    val nerve: ResistanceType,
    val curse: ResistanceType,
)