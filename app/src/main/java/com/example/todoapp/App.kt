package com.example.todoapp

import android.app.Application
import com.example.todoapp.database.AppDatabase

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        AppDatabase.initDatabase(this)
    }
}