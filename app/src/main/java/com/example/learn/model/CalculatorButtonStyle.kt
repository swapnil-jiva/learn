package com.example.learn.model

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class CalculatorButtonStyle(
    val backgroundColor: Color = Color.LightGray,
    val fontSize: TextUnit = 35.sp,
    val padding: Dp = 5.dp,
    val shape: RoundedCornerShape = RoundedCornerShape(40.dp),
    val buttonSize: Dp = 100.dp,
    val fontWeight: FontWeight = FontWeight.Bold,
    val fontColor: Color = Color.White,
    val buttonWidth: Dp = 85.dp,
)
