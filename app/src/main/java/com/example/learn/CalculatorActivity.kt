package com.example.learn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learn.lib.ExpressionEvaluator
import com.example.learn.ui.components.CalculatorDisplay
import com.example.learn.ui.components.CalculatorKeypad
import com.example.learn.ui.theme.LearnTheme

class CalculatorActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnTheme {
                CalculatorView()
            }
        }
    }
}

@Composable
fun CalculatorView() {
    val solution = remember { mutableStateOf("0") }
    val expression = remember { mutableStateOf("") }

    ElevatedCard(
        modifier =
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(10.dp),
        colors =
            CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
            ),
        elevation =
            CardDefaults.cardElevation(
                defaultElevation = 1.dp,
            ),
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.padding(15.dp),
        ) {
            Column {
                CalculatorDisplay(
                    expression = expression,
                    solution = solution,
                )
                CalculatorKeypad(
                    onButtonClick = { input ->
                        updateExpression(input, expression, solution)
                    },
                )
            }
        }
    }
}

private fun updateExpression(
    input: String,
    expression: MutableState<String>,
    solution: MutableState<String>,
) {
    val operators = listOf("÷", "×", "-", "+", "%")
    val lastChar = expression.value.lastOrNull()?.toString() ?: ""

    if (operators.contains(lastChar) && operators.contains(input)) {
        expression.value = expression.value.dropLast(1) + input
        return
    }

    when (input) {
        "C" -> {
            expression.value = ""
            solution.value = "0"
        }
        "=" -> {
            val result = evaluateExpression(expression.value)
            solution.value = result.toString()
        }
        "±" -> {
//            handle negation
        }
        else -> {
            expression.value += input
        }
    }
}

private fun evaluateExpression(expression: String): String =
    try {
        val result = ExpressionEvaluator.evaluate(expression)
        result
    } catch (e: Exception) {
        "Error"
    }

@Preview(showBackground = true)
@Composable
fun CalculatorViewPreview() {
    LearnTheme {
        CalculatorView()
    }
}
