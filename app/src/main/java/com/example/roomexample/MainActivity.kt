package com.example.roomexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.roomexample.ui.theme.RoomExampleTheme

class MainActivity : ComponentActivity() {

    val TAG = "메인 액티비티"
    lateinit var mainViewModel: MainViewModel
    lateinit var mainComposable: MainComposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel = MainViewModel()
        mainComposable = MainComposable(mainViewModel)

        setContent {

            RoomExampleTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    mainComposable.Greeting("Android",modifier = Modifier)

                }

            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    val mainViewModel = MainViewModel()
    val mainComposable = MainComposable(mainViewModel)

    RoomExampleTheme {

        mainComposable.Greeting(name = "Android", modifier = Modifier)

    }

}