package com.example.myapplication.BD

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "Binding",
    primaryKeys = ["Recipe_ID", "Components_ID"],
    foreignKeys = [
        ForeignKey(entity = Components::class, parentColumns = ["IDComponent"], childColumns = ["Components_ID"]),
        ForeignKey(entity = Recipe::class, parentColumns = ["IDRecipe"], childColumns = ["Recipe_ID"])
    ])
data class Binding(
    val Components_ID: Int,
    val Recipe_ID: Int
)
