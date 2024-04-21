package com.example.myapplication.BD

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Components")
data class Components(
    @PrimaryKey(autoGenerate = true) var IDComponent: Int? = null,
    var Component: String
)
