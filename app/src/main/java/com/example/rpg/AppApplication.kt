package com.example.rpg

import android.app.Application
import com.example.rpg.data.AppDbContext

class AppApplication : Application() {
    lateinit var db: AppDbContext

    override fun onCreate() {
        super.onCreate()
        db = AppDbContext.getDatabase(this)
    }
}