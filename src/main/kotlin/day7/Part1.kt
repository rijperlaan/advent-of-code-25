package org.example.day7

import org.example.readInput

private var splits = 0

fun main() {
    println("--- Day 7 Part 1 ---")

    val inputs = readInput("day7/example.txt").toMutableList()

    val sIndex = inputs.first().indexOf('S')

    traceBeam(sIndex, 1, inputs)

    println("total = $splits")
}

fun traceBeam(beamIndex : Int, currentRow : Int, inputs : MutableList<String>) {
    if (currentRow >= inputs.size) {
        return
    }

    if (beamIndex < 0 || beamIndex >= inputs[currentRow].length) {
        return
    }

    if (inputs[currentRow][beamIndex] == '.') {
        val sb = StringBuilder(inputs[currentRow])
        sb[beamIndex] = '|'
        inputs[currentRow] = sb.toString()
        traceBeam(beamIndex, currentRow + 1, inputs)
    } else if (inputs[currentRow][beamIndex] == '^') {
        splits++
        traceBeam(beamIndex - 1, currentRow, inputs)
        traceBeam(beamIndex + 1, currentRow, inputs)
    }

}

