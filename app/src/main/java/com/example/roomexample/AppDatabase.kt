package com.example.roomexample

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomexample.data.Schedule

@Database(entities = [Schedule::class], version = 0,exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun scheduleDao(): ScheduleDao

}