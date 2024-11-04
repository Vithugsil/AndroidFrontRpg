package com.example.rpg.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "character")
data class CharacterEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    @ColumnInfo(name = "name_character")
    val name: String,

    @ColumnInfo(name = "breed_character")
    val breed: String,

    @ColumnInfo(name = "class_character")
    val classCharacter: String,

    @ColumnInfo(name = "strength_character")
    val strength: Int,

    @ColumnInfo(name = "dexterity_character")
    val dexterity: Int,

    @ColumnInfo(name = "constitution_character")
    val constitution: Int,

    @ColumnInfo(name = "intelligence_character")
    val intelligence: Int,

    @ColumnInfo(name = "wisdom_character")
    val wisdom: Int,

    @ColumnInfo(name = "charisma_character")
    val charisma: Int,
)