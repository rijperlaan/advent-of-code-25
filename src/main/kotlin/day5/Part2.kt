package org.example.day5

import org.example.readInput

fun main() {
    println("--- Day 5 Part 2 ---")

    val inputs = readInput("day5/input.txt")
    var total = 0L

    val blankIndex = inputs.indexOf("")
    val rangeLines = inputs.subList(0, blankIndex)
    val rangeArrays = rangeLines.map { line -> line.split("-") }
    var ranges = rangeArrays.map { it[0].toLong()..it[1].toLong() }
    val combinedRanges = ranges.toMutableSet()

    // Combine all the ranges that overlap
    do {
        ranges = combinedRanges.toList()

        for (currentRange in ranges) {
            for (checkRange in ranges) {
                if (currentRange != checkRange && checkRange.overlaps(currentRange)) {
                    combinedRanges.remove(currentRange)
                    combinedRanges.remove(checkRange)
                    val combinedRange = combine(checkRange, currentRange)
                    combinedRanges.add(combinedRange)
                }
            }
        }
    } while (combinedRanges.size != ranges.size)

    // Count the amount of ids per range
    for (currentRange in combinedRanges) {
        total += currentRange.last - currentRange.first + 1
    }

    println("Total: $total")
}

fun LongRange.overlaps(other: LongRange): Boolean {
    return this.first <= other.last && other.first <= this.last
}

fun combine(one: LongRange, two: LongRange): LongRange {
    val newStart = minOf(one.first, two.first)
    val newEnd = maxOf(one.last, two.last)
    return newStart..newEnd
}