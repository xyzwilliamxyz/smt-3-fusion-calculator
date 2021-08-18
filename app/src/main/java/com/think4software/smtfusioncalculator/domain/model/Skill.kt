package com.think4software.smtfusioncalculator.domain.model

import com.think4software.smtfusioncalculator.domain.enums.ElementType
import com.think4software.smtfusioncalculator.domain.enums.InheritableSkillType

data class Skill(
    val skillId: Int,
    val name: String,
    val element: ElementType,
    val cost: String,
    val effect: String,
    val target: String,
    val rank: Int,
    var inherit: InheritableSkillType,
    var level: String = "",
    var unique: Boolean
)