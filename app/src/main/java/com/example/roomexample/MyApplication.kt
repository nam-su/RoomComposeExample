package com.example.roomexample

import android.app.Application
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class MyApplication: Application() {

    val database = Room.
    databaseBuilder(applicationContext,AppDatabase::class.java,"database-name")
        .fallbackToDestructiveMigration()
        .build()

}
