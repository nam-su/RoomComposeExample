package com.example.roomexample

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.roomexample.data.Schedule

@Dao
interface ScheduleDao {

    @Query("SELECT * FROM schedule")
    fun getAllSchedule(): ArrayList<Schedule>

    @Insert
    fun insertSchedule(vararg schedules: Schedule)

    @Delete
    fun delete(schedule: Schedule)

}