package org.example.day6

import org.example.readInput

fun main() {
    println("--- Day 6 Part 1 ---")

    val inputs = readInput("day6/input.txt")
    var total = 0L
    val rows = mutableListOf<List<Long>>()


    for (i in 0..<inputs.size - 1) {
        val row = inputs[i].trim().split(Regex("\\s+")).map { it.toLong() }
        rows.add(row)
    }

    val operators = inputs[inputs.size - 1].trim().split(Regex("\\s+"))

    for (i in 0..<operators.size) {
        var columnTotal = 0L

        if (operators[i] == "+") {
            for (j in 0..<rows.size) {
                columnTotal += rows[j][i]
            }
        } else {
            for (j in 0..<rows.size) {
                if (columnTotal == 0L) {
                    columnTotal = rows[j][i]
                } else {
                    columnTotal *= rows[j][i]
                }
            }
        }

        println("columnTotal = $columnTotal")
        total += columnTotal
    }

    println("Total: $total")
}