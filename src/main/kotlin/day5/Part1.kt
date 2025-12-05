package org.example.day5

import org.example.readInput

fun main() {
    println("--- Day 5 Part 1 ---")

    val inputs = readInput("day5/input.txt")
    var total = 0

    val blankIndex = inputs.indexOf("")
    val rangeLines = inputs.subList(0, blankIndex)
    val rangeArrays = rangeLines.map { line -> line.split("-") }
    val ranges = rangeArrays.map { it[0].toLong()..it[1].toLong() }

    val ids = inputs.subList(blankIndex + 1, inputs.size).map { it.toLong() }

    for (id in ids) {
        for (range in ranges) {
            if (id in range) {
                total++
                break
            }
        }
    }

    println("Total: $total")
}