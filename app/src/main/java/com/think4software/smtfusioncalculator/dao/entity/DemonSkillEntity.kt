package com.think4software.smtfusioncalculator.dao.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "demon_skill",
    foreignKeys = [ForeignKey(
        entity = DemonEntity::class,
        parentColumns = ["demon_id"],
        childColumns = ["demon_id"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index(
        "demon_id"
    ), Index(
        "skill_id"
    )]
)
data class DemonSkillEntity(
    @ColumnInfo(name = "demon_skill_id")
    @PrimaryKey(autoGenerate = true)
    val demonSkillId: Int,
    @ColumnInfo(name = "skill_id")
    val skillId: Int,
    val level: Int,
    @ColumnInfo(name = "demon_id")
    val demonId: Int
)