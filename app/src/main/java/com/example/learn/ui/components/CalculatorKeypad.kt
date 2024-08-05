package com.example.learn.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Suppress("ktlint:standard:function-naming")
@Composable
fun CalculatorKeypad(onButtonClick: (String) -> Unit) {
    Box(
        modifier =
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
        contentAlignment = Alignment.BottomCenter,
    ) {
        Column {
            arrayOf(
                arrayOf("C", "±", "%", "÷"),
                arrayOf("7", "8", "9", "×"),
                arrayOf("4", "5", "6", "-"),
                arrayOf("1", "2", "3", "+"),
                arrayOf("0", ".", "="),
            ).forEach {
                Row {
                    it.forEach {
                        CalculatorButton(
                            text = it,
                            onClick = {
                                onButtonClick(it)
                            },
                        )
                    }
                }
            }
        }
    }
}
