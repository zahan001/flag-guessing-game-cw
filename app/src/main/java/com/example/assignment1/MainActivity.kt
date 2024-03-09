package com.example.assignment1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment1.ui.theme.Assignment1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                
                Button(onClick = {
                    val option1 = Intent(this@MainActivity, GuessTheFlag::class.java)
                    startActivity(option1)
                }) {
                    Text(text = "Guess The Country", fontSize = 18.sp)

                }

                Button(onClick = {
                    val option2 = Intent(this@MainActivity, GuessHints::class.java)
                    startActivity(option2)
                }) {
                    Text(text = "Guess Hints", fontSize = 18.sp)

                }

                Button(onClick = {
                    val option3 = Intent(this@MainActivity, GuessTheCountryFlag::class.java)
                    startActivity(option3)
                }) {
                    Text(text = "Guess The Flag", fontSize = 18.sp)

                }

                Button(onClick = {
                    val option4 = Intent(this@MainActivity, AdvancedLevel::class.java)
                    startActivity(option4)
                }) {
                    Text(text = "Advanced Level", fontSize = 18.sp)

                }

            }
        }
    }
}
