package com.think4software.smtfusioncalculator.domain.model

data class Demon(
    val demonId: Int,
    val name: String,
    val level: Int,
    val race: String,
    val price: Int,
    val hp: Int,
    val mp: Int,
    val strength: Int,
    val magic: Int,
    val vitality: Int,
    val agility: Int,
    val luck: Int,
    var evolvesFrom: DemonEvolution? = null,
    var evolvesTo: DemonEvolution? = null,
    val specialFusionCondition: String = "",
    val resistances: DemonResistances,
    val inheritances: DemonInheritances,
    var skills: List<Skill> = listOf(),
    var reverseFusions: List<ReverseFusion> = listOf(),
    var forwardFusions: List<ForwardFusion> = listOf(),
)