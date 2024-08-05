package com.example.learn.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.learn.model.CalculatorButtonStyle

@Composable
fun CalculatorButton(
    text: String,
    onClick: () -> Unit,
) {
    val operatorStyle =
        CalculatorButtonStyle(
            backgroundColor = Color(0xFFEF6C00),
        )
    val numberStyle =
        CalculatorButtonStyle(
            fontColor = Color(0xFF212121)
        )
    val equalsStyle =
        CalculatorButtonStyle(
            backgroundColor = Color(0xFF1565C0),
        )
    val specialStyle =
        CalculatorButtonStyle(
            backgroundColor = Color.Gray,
        )
    val zeroStyle =
        CalculatorButtonStyle(
            backgroundColor = Color.LightGray,
            fontColor = Color(0xFF212121),
            buttonWidth = 170.dp,
        )

    val style =
        when (text) {
            "÷", "×", "-", "+" -> operatorStyle
            "=" -> equalsStyle
            "C", "±", "%" -> specialStyle
            "0" -> zeroStyle
            else -> numberStyle
        }

    Button(
        onClick = onClick,
        shape = style.shape,
        modifier =
            Modifier
                .width(style.buttonWidth)
                .size(style.buttonSize)
                .padding(style.padding),
        colors =
            ButtonDefaults.buttonColors(
                containerColor = style.backgroundColor,
            ),
    ) {
        Text(
            text = text,
            fontSize = style.fontSize,
            fontWeight = style.fontWeight,
            color = style.fontColor,
        )
    }
}
