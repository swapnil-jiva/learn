package com.example.learn.lib

class ExpressionEvaluator {
    companion object {
        fun evaluate(expression: String): String =
            try {
                val result = ExpressionParser(expression).parse()
                if (result.isNaN()) {
                    "Error"
                } else {
                    if (result % 1 == 0.0) {
                        result.toInt().toString()
                    } else {
                        result.toString()
                    }
                }
            } catch (e: Exception) {
                "Error"
            }
    }
}

class ExpressionParser(
    private val expression: String,
) {
    private var index = 0

    fun parse(): Double = parseExpression()

    private fun parseExpression(): Double {
        var result = parseTerm()

        while (index < expression.length) {
            val operator = expression[index]
            if (operator == '+' || operator == '-') {
                index++
                val term = parseTerm()
                if (operator == '+') {
                    result += term
                } else {
                    result -= term
                }
            } else {
                break
            }
        }

        return result
    }

    private fun parseTerm(): Double {
        var result = parseFactor()

        while (index < expression.length) {
            val operator = expression[index]
            if (operator == '×' || operator == '÷') {
                index++
                val factor = parseFactor()
                if (operator == '×') {
                    result *= factor
                } else {
                    result /= factor
                }
            } else {
                break
            }
        }

        return result
    }

    private fun parseFactor(): Double {
        val start = index
        if (expression[index] == '(') {
            index++
            val result = parseExpression()
            if (expression[index] != ')') {
                throw IllegalArgumentException("Expected ')'")
            }
            index++
            return result
        } else {
            while (index < expression.length && expression[index].isDigit()) {
                index++
            }
            return expression.substring(start, index).toDouble()
        }
    }
}
