package com.example.learn.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Suppress("ktlint:standard:function-naming")
@Composable
fun CalculatorDisplay(
    expression: MutableState<String>,
    solution: MutableState<String>,
) {
    Card(
        colors =
            CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.onSecondaryContainer,
            ),
        modifier =
            Modifier
                .fillMaxWidth()
                .height(280.dp),
    ) {
        Box(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(15.dp),
            contentAlignment = Alignment.BottomEnd,
        ) {
            Column(
                horizontalAlignment = Alignment.End,
            ) {
                Text(
                    text = expression.value,
                    fontSize = 22.sp,
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp),
                    color = MaterialTheme.colorScheme.secondary,
                    fontWeight = FontWeight.W500,
                )

                Text(
                    text = solution.value,
                    fontSize = 45.sp,
                    modifier = Modifier.padding(0.dp, 8.dp, 0.dp, 0.dp),
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.W800,
                )
            }
        }
    }
}
