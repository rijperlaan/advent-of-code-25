package org.example.day1

import org.example.readInput

fun main() {
    println("--- Day1 Part 1 ---")

    val inputs = readInput("day1/input.txt")

    var dial = 50
    var zeros = 0

    inputs.forEach { cmd ->
        val direction = cmd[0]
        val value = cmd.drop(1).toInt()

        dial = if (direction == 'L') dial - value else dial + value
        dial %= 100
        if (dial == 0) zeros++
    }

    println(zeros)

}