package org.example.day7

import org.example.readInput

private val pathsPerCell = mutableMapOf<Pair<Int, Int>, Long>()

fun main() {
    println("--- Day 7 Part 2 ---")

    val inputs = readInput("day7/input.txt").toMutableList()

    val sIndex = inputs.first().indexOf('S')

    val total = countBeamPaths(sIndex, 1, inputs)

    println("total = $total")
}

fun countBeamPaths(beamIndex: Int, currentRow: Int, inputs: List<String>): Long {
    if (currentRow >= inputs.size) {
        return 1L
    }

    if (beamIndex < 0 || beamIndex >= inputs[currentRow].length) {
        return 0L
    }

    val cell = Pair(beamIndex, currentRow)
    // Make sure we don't count partial paths more than once
    if (pathsPerCell[cell] != null) {
        return pathsPerCell[cell]!!
    }

    val result =
        if (inputs[currentRow][beamIndex] == '.') {
            countBeamPaths(beamIndex, currentRow + 1, inputs)
        } else if (inputs[currentRow][beamIndex] == '^') {
            countBeamPaths(beamIndex - 1, currentRow, inputs) + countBeamPaths(beamIndex + 1, currentRow, inputs)
        } else {
            0L
        }

    // Save counted path
    pathsPerCell[cell] = result
    return result
}

