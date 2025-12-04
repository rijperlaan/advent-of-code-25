package org.example.day4

import org.example.readInput

fun main() {
    println("--- Day 4 Part 1 ---")

    val inputs = readInput("day4/input.txt")
    var total = 0

    for (i in 0..<inputs.size) {
        for (j in 0..<inputs.size) {
            if (inputs[i][j] != '@') {
                continue
            }

            var rolls = 0

            for (x in i - 1..i + 1) {
                for (y in j - 1..j + 1) {
                    if (x >= 0 &&
                        y >= 0 &&
                        x < inputs.size
                        && y < inputs[x].length
                        && "$x$y" != "$i$j"
                        && inputs[x][y] == '@') {
                        rolls++
                    }
                }
            }

            if (rolls < 4) {
                total++
            }
        }
    }

    println("Total: $total")
}