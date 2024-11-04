package com.example.createa30daysapp.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Definisikan warna kustom Anda
private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF4CAF50), // Hijau untuk warna utama
    onPrimary = Color.White,
    background = Color(0xFFE8F5E9),
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black
)

@Composable
fun WellnessAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography(),
        content = content
    )
}
