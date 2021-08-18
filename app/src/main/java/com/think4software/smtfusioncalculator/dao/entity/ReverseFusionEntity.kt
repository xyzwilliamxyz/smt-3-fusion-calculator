package com.think4software.smtfusioncalculator.dao.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "reverse_demon_fusion",
    foreignKeys = [ForeignKey(
        entity = DemonEntity::class,
        parentColumns = ["demon_id"],
        childColumns = ["demon_id"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index(
        "demon_id"
    ), Index(
        "ingredient_one"
    ), Index(
        "ingredient_two"
    )]
)
data class ReverseFusionEntity(
    @ColumnInfo(name = "demon_fusion_id")
    @PrimaryKey(autoGenerate = true)
    val demonFusionId: Int,
    @ColumnInfo(name = "demon_id")
    val demonId: Int,
    @ColumnInfo(name = "ingredient_one") val ingredientOne: Int,
    @ColumnInfo(name = "ingredient_two") val ingredientTwo: Int,
)