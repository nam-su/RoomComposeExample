package com.example.roomexample

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.roomexample.data.Schedule
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.util.Locale

class MainViewModel: ViewModel() {

    // 메인 모델 초기화
    val model = MainModel()

    // 현재 날짜
    val currentMonth = mutableStateOf(YearMonth.now())

    // 고른 날짜
    val selectedDay = mutableStateOf<Int?>(null) // 상태 변수 선언

    // 고른날짜데이터를 yyyy-MM-DD 형태로 변환
    private val _selectedDateString = MutableLiveData<String>()
    val selectedDateString:LiveData<String> get() = _selectedDateString

    // 날짜 양식 패턴화
    val monthFormatter = DateTimeFormatter.ofPattern("yyyy년 MMMM", Locale.getDefault())

    // 고른 날짜 데이터 날짜와 일정 날짜 일치 하는 데이터 filter한 리스트
    val schedules = MutableLiveData<List<Schedule>>()


    fun setSelectedDataString() {

        selectedDay.value?.let { day ->
            "${currentMonth.value}-${day.toString().padStart(2, '0')}"
        }

//        selectedDay.value?.let { day ->
//            val dateString = "${currentMonth.value}-${day.toString().padStart(2, '0')}"
//            _selectedDateString.value = dateString // 실제 값 설정
//        }

    }

    fun setScheduleList() {

        schedules.value = selectedDateString.value?.let { date ->

            model.scheduleList.filter { it.scheduleDate == date }

        } ?: emptyList()

    }

}