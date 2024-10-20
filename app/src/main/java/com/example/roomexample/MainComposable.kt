package com.example.roomexample

import android.widget.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.YearMonth

class MainComposable(private val viewModel: MainViewModel) {

    @Composable
    fun Greeting() {
        /** 가장 상위 뷰 **/
        /** Column 속성을 이용해 뷰를 세로로 배치 **/
        Column(

            modifier = Modifier.fillMaxSize(),

            // 컴포넌트들이 위에서부터 순차적으로 배치
            verticalArrangement = Arrangement.Top

        ) {

            // 상단 (이전 날짜 버튼 , 현재 날짜 , 다음 날짜 버튼)
            MainTitle(

                currentMonth = viewModel.currentMonth.value,

                onPreviousMonth = {

                    viewModel.currentMonth.value = viewModel.currentMonth.value.minusMonths(1)
                    viewModel.selectedDay.value = null

                } ,

                onNextMonth =  {
                    viewModel.currentMonth.value = viewModel.currentMonth.value.plusMonths(1)
                    viewModel.selectedDay.value = null // 날짜 변경 시 선택된 날짜 초기화
                }

            )

            // 메인

        }

    }

    // 상단 바 View
    @Composable
    fun MainTitle(currentMonth: YearMonth,

                  onPreviousMonth: () -> Unit,

                  onNextMonth: () -> Unit) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            // 이전 날짜 버튼
            // 버튼 클릭시 onPreviousMonth 실행
            Button(
                onClick = onPreviousMonth,
                modifier = Modifier
                    .padding(15.dp)
                    .weight(2.2f)
            ) {

                Text(
                    "이전 날짜",
                    style = TextStyle(
                        fontSize = 10.sp
                    )
                )

            }

            // 텍스트를 가운데 정렬하기 위해, Modifier에 fillMaxWidth()와 padding을 추가
            Box(
                modifier = Modifier
                    .weight(2.8f)  // 현재 월 텍스트에 2f weight 적용
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = currentMonth.format(viewModel.monthFormatter),
                    color = Color.Black,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    ),
                    modifier = Modifier.align(Alignment.Center)  // 텍스트 가운데 정렬
                )
            }

            // 버튼 클릭시 onNextMonth 실행
            Button(
                onClick = onNextMonth,
                modifier = Modifier
                    .padding(15.dp)
                    .weight(2.2f)
            ) {

                Text(
                    text = "다음 날짜",
                    style = TextStyle(
                        fontSize = 10.sp
                    )
                )

            }

        }

    }

}