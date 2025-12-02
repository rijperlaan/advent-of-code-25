package org.example.day1

import org.example.readInput

fun main() {
    println("--- Day1 Part2 ---")

    val inputs = readInput("day1/input.txt")

    var currentDial = 50
    var zeros = 0

    inputs.forEach { cmd ->
        val direction = cmd[0]
        val turnValue = cmd.drop(1).toInt()

        if (direction == 'R') {
            for (i in 1..turnValue) {
                if ((currentDial + i) % 100 == 0) {
                    zeros++
                }
            }
            currentDial = (currentDial + turnValue) % 100
        } else {
            for (i in 1..turnValue) {
                if ((currentDial - i) % 100 == 0) {
                    zeros++
                }
            }
            currentDial = (currentDial - turnValue) % 100
        }
    }

    println(zeros)
}
