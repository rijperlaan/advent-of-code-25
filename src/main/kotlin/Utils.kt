package org.example

fun readInput(name: String): List<String> =
    object {}.javaClass.getResourceAsStream("/$name")!!
        .bufferedReader()
        .readLines()

fun readInputLine(name: String): String =
    object {}.javaClass.getResourceAsStream("/$name")!!
        .bufferedReader()
        .readLine()