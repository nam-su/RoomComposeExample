package com.example.roomexample

import com.example.roomexample.data.Schedule
import java.time.format.DateTimeFormatter
import java.util.Locale

class MainModel {

    val monthFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MMMM", Locale.getDefault())

    val scheduleList = listOf(
        Schedule(0, "2024-09-06","세미나 전날","세미나 준비 마무리 하자"),
        Schedule(1, "2024-09-07","세미나 당일","세미나 발표를 잘하자"),
        Schedule(2, "2024-09-07","세미나 다음날","세미나 했으니 좀 쉬자")
    )

}