package org.example.day6

import org.example.readInput

fun main() {
    println("--- Day 6 Part 2 ---")

    val inputs = readInput("day6/input.txt")

    //val chunked = inputs.map { line -> line.chunked(maxLength + 1).map { it.take(maxLength) } }
    val chunked = splitKeepingPadding(inputs)

    println("chunked = ${chunked}")
    // Transpose (turn rows into columns)
    val transposed = chunked[0].indices.map { col -> chunked.map { it[col] } }.reversed()

    var total = 0L

    println("transposed = ${transposed}")

    for (row in transposed) {
        val operator = row[row.size - 1].trim()

        val newProblems = mutableListOf<String>()

        for (i in 0..<row[0].length) {
            val s = CharArray(row.size - 1) { ' ' }

            for (j in 0..<row.size - 1) {
                s[j] = row[j][i]
            }

            newProblems.add(s.concatToString())
        }

        val newNumbers = newProblems.map { it.trim().toLong() }.reversed()

        var subTotal: Long
        if (operator == "+") {
            subTotal = newNumbers.sum()
        } else {
            subTotal = 1L
            for (k in 0..<newNumbers.size) {
                subTotal *= newNumbers[k]
            }
        }

        total += subTotal

    }

    println("Total: $total")
}

fun splitKeepingPadding(inputs: List<String>): List<List<String>> {
    val whitespaces = mutableListOf<Int>()

    for (i in 0..<inputs[1].length) {
        var whitespace = true

        for (j in 0..<inputs.size - 1) {
            if (inputs[j][i] != ' ') {
                whitespace = false
                break
            }
        }

        if (whitespace) {
            whitespaces.add(i)
        }
    }

    println("whitespaces = ${whitespaces}")

    val result = mutableListOf<List<String>>()

    for (line in inputs) {
        result.add(splitAtIndices(line, whitespaces))
    }

    println("result = ${result}")
    return result
}

fun splitAtIndices(s: String, indices: List<Int>): List<String> {
    val result = mutableListOf<String>()
    var start = 0

    for (i in indices) {
        result.add(s.substring(start, i))
        start = i + 1
    }

    // add the last segment
    result.add(s.substring(start))

    return result
}
