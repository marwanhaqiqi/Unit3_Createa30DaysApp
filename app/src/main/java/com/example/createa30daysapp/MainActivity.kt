package com.example.createa30daysapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.createa30daysapp.ui.theme.WellnessAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WellnessAppTheme {
                WellnessApp()
            }
        }
    }
}

@Composable
fun WellnessApp() {
    // Daftar tips wellness untuk 30 hari
    val wellnessTips = List(30) { index ->
        WellnessTip(
            day = "Day ${index + 1}",
            title = if (index == 0) "Spend 15 minutes outdoors" else "Listen to a new podcast or audiobook",
            description = if (index == 0) "Put some time on your calendar to take a walk outside or maybe even take a meeting while you're strolling through your neighborhood."
            else "Listen to a podcast and explore a topic you’ve been itching to learn more about or discover a completely new topic or genre of podcast content.",
            imageRes = if (index == 0) R.drawable.outdoors else R.drawable.podcast
        )
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(wellnessTips.size) { index ->
            WellnessCard(tip = wellnessTips[index])
        }
    }
}

@Composable
fun WellnessCard(tip: WellnessTip) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFE8F5E9) // Warna latar belakang card
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = tip.day,
                fontSize = 14.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = tip.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = tip.imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = tip.description,
                fontSize = 14.sp,
                color = Color.DarkGray
            )
        }
    }
}

data class WellnessTip(
    val day: String,
    val title: String,
    val description: String,
    val imageRes: Int
)
