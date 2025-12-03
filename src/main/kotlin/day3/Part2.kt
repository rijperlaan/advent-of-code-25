package org.example.day3

import org.example.readInput

fun main() {
    println("--- Day 3 Part 2 ---")

    val inputs = readInput("day3/input.txt")

    var total = 0L

    inputs.forEach { inputLine ->
        val result = recursiveSearch(inputLine, 12)
        total += result.toLong()
    }

    println("Total: $total")
}

fun recursiveSearch(joltageLine: String, digits: Int): String {
    // If no more digits left to go, return empty and end recursion
    if (digits < 1) {
        return ""
    }

    if (joltageLine.length == digits) {
        return joltageLine
    }

    // Make sure we have enough digits left to finish the 12 digits
    val options = joltageLine.take(joltageLine.length - digits + 1)
    // Split options into Ints
    val optionInts = options.chunked(1).map { it.toInt() }
    // Take biggest
    val maxOption = optionInts.max()

    // Remove the digit we took and everything before it
    val maxOptionIndex = joltageLine.indexOf("$maxOption")
    val newJoltageLine = joltageLine.drop(maxOptionIndex + 1)

    // Return the max available digit, concatenated by the next digit
    return "$maxOption${recursiveSearch(newJoltageLine, digits - 1)}"
}