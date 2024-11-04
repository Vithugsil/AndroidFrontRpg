package com.example.rpg.data

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [CharacterEntity::class], version = 1)
abstract class AppDbContext : RoomDatabase() {

    abstract fun characterDao(): CharacterDAO

    companion object {

        fun getDatabase(application: Application): AppDbContext {
            return Room.databaseBuilder(
                application,
                AppDbContext::class.java,
                "character_database"
            ).allowMainThreadQueries().build()
        }
    }

}