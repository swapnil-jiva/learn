package com.example.learn

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learn.ui.theme.LearnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    profileHeader(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}

@Composable
fun SuggestionChipExample(name: String) {
    SuggestionChip(
        onClick = { Log.d("Suggestion chip", "hello world") },
        label = { Text("$name") },
        modifier = Modifier.padding(horizontal = 8.dp).width(100.dp)
    )
}

@Composable
fun profileHeader(
    name: String,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier.size(400.dp)) {
        Column {
            Text(
                text = "Developer Profile",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
            )
            Card(modifier = Modifier.padding(20.dp)) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Row {
                        Image(
                            modifier =
                                Modifier
                                    .size(
                                        100.dp,
                                        100.dp,
                                    ).padding(10.dp).clip(CircleShape),
                            painter = painterResource(id = R.drawable.bgshow),
                            contentDescription = "Profile Picture",
                        )
                        Column(modifier = Modifier.offset(0.dp,20.dp)) {
                            Text(text = name,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp)
                            Text(text = "Android Developer",
                                fontSize = 16.sp)
                        }
                    }
                    Text(text = "Skills",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp)
                    Row {
                        SuggestionChipExample("Kotlin")
                        SuggestionChipExample("Jetpack Compose")
                        SuggestionChipExample("Android")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun profileHeaderPreview() {
    LearnTheme {
        profileHeader("Swapnil Sable")
    }
}
