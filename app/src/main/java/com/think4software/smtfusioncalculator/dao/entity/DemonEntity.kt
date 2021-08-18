package com.think4software.smtfusioncalculator.dao.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "demon",
    indices = [Index(
        "evolves_from"
    ), Index(
        "evolves_to"
    )]
)
data class DemonEntity(
    @ColumnInfo(name = "demon_id")
    @PrimaryKey(autoGenerate = false)
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
    @ColumnInfo(name = "evolves_from") val evolvesFrom: Int,
    @ColumnInfo(name = "evolves_from_level") val evolvesFromLevel: Int,
    @ColumnInfo(name = "evolves_to") val evolvesTo: Int,
    @ColumnInfo(name = "evolves_to_level") val evolvesToLevel: Int,
    @ColumnInfo(name = "special_fusion_condition") val specialFusionCondition: String,

    @ColumnInfo(name = "res_physical") var resPhysical: Int,
    @ColumnInfo(name = "res_fire") var resFire: Int,
    @ColumnInfo(name = "res_ice") var resIce: Int,
    @ColumnInfo(name = "res_thunder") var resThunder: Int,
    @ColumnInfo(name = "res_wind") var resWind: Int,
    @ColumnInfo(name = "res_expel") var resExpel: Int,
    @ColumnInfo(name = "res_death") var resDeath: Int,
    @ColumnInfo(name = "res_mind") var resMind: Int,
    @ColumnInfo(name = "res_nerve") var resNerve: Int,
    @ColumnInfo(name = "res_curse") var resCurse: Int,

    @ColumnInfo(name = "inherit_thrust") var inheritThrust: Boolean,
    @ColumnInfo(name = "inherit_claw") var inheritClaw: Boolean,
    @ColumnInfo(name = "inherit_bite") var inheritBite: Boolean,
    @ColumnInfo(name = "inherit_weapon") var inheritWeapon: Boolean,
    @ColumnInfo(name = "inherit_mouth") var inheritMouth: Boolean,
    @ColumnInfo(name = "inherit_wings") var inheritWings: Boolean,
    @ColumnInfo(name = "inherit_eye") var inheritEye: Boolean,
    @ColumnInfo(name = "inherit_talk") var inheritTalk: Boolean,
    @ColumnInfo(name = "inherit_maiden") var inheritMaiden: Boolean,
)