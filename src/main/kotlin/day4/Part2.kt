package org.example.day4

import org.example.readInput

fun main() {
    println("--- Day 4 Part 2 ---")

    val inputs = readInput("day4/input.txt")

    val grid = inputs.toMutableList()
    var newTotal = 0
    var oldTotal = -1

    while (oldTotal != newTotal) {
        oldTotal = newTotal

        for (i in 0..<grid.size) {
            for (j in 0..<grid.size) {
                if (grid[i][j] != '@') {
                    continue
                }

                var rolls = 0

                for (x in i - 1..i + 1) {
                    for (y in j - 1..j + 1) {
                        if (x >= 0 &&
                            y >= 0 &&
                            x < grid.size
                            && y < grid[x].length
                            && "$x$y" != "$i$j"
                            && grid[x][y] == '@'
                        ) {
                            rolls++
                        }
                    }
                }

                if (rolls < 4) {
                    val sb = StringBuilder(grid[i])
                    sb[j] = '-'
                    grid[i] = String(sb)
                    newTotal++
                }
            }
        }
    }

    println("Total: $newTotal")
}