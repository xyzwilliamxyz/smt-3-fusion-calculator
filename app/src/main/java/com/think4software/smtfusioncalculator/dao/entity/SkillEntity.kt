package com.think4software.smtfusioncalculator.dao.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "skill")
data class SkillEntity(
    @ColumnInfo(name = "skill_id")
    @PrimaryKey(autoGenerate = false)
    val skillId: Int,
    val name: String,
    val element: Int,
    val cost: String,
    val effect: String,
    val target: String,
    val rank: Int,
    val inherit: Int,
    @ColumnInfo(name = "uniquee") val unique: Boolean
)