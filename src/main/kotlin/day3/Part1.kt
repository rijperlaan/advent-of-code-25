package org.example.day3

import org.example.readInput

fun main() {
    println("--- Day 3 Part 1 ---")

    val inputs = readInput("day3/input.txt")

    var total = 0

    inputs.forEach { cmd ->
        val joltages = cmd.chunked(1).map { it.toInt() }

        var highest = 0

        for (i in 0..<joltages.size) {
            for (j in i+1..<joltages.size) {
                val combined = "${joltages[i]}${joltages[j]}".toInt()
                if (combined > highest) {
                    highest = combined
                }
            }
        }
        println("$cmd : $highest")
        total += highest
    }

    println("Total: $total")
}