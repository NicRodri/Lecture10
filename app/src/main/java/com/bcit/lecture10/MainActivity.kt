package com.bcit.lecture10

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bcit.lecture10.ui.main.MainContent
import com.bcit.lecture10.ui.main.UserState
import com.bcit.lecture10.ui.theme.Lecture10Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val userRepository = (application as MyApp).userRepository



        setContent {
            val userState = remember {
                UserState(userRepository)
            }
            MainContent(userState)
        }
    }
}
