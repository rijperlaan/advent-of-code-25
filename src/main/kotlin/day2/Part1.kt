package org.example.day2

import org.example.readInputLine

fun main() {
    println("--- Day 2 Part 1 ---")

    val inputs = readInputLine("day2/input.txt").split(",")

    val invalids = mutableSetOf<Long>()

    inputs.forEach { cmd ->
        val range = cmd.split("-")
        val start = range[0].toLong()
        val end = range[1].toLong()

        for (i in start..end) {
            val id = "$i"
            for (j in 1..id.length / 2) {
                if (id.take(j) == id.drop(j)) {
                    invalids.add(i)
                }
            }
        }
    }

    println(invalids)
    println("Sum: ${invalids.sum()}")
}