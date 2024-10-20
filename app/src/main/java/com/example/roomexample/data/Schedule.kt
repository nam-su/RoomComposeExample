package com.example.roomexample.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "schedule")
data class Schedule(

    @PrimaryKey val num: Int,
    @ColumnInfo(name = "scheduleDate") val scheduleDate: String,
    @ColumnInfo(name = "scheduleTitle") val scheduleTitle: String,
    @ColumnInfo(name = "scheduleContent") val scheduleContent: String

)
