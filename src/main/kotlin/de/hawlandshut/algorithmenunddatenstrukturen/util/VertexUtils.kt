package de.hawlandshut.algorithmenunddatenstrukturen.util

import java.io.BufferedReader
import java.io.FileReader
import java.util.*
import java.util.stream.Collectors

fun readVerticesFromFile(filename: String): List<Pair<Int, Int>> {
    val edgeList = ArrayList<Pair<Int, Int>>()

    val path = Thread.currentThread().contextClassLoader.getResource(filename).path
    println(path)
    val reader = BufferedReader(FileReader(path))
    return reader.lines()
            .filter{ !it.isBlank() }
            .map{ it.split(" ") }
            .map { Pair(it[0].toInt(), it[1].toInt()) }
            .collect(Collectors.toList())
}