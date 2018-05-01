package de.hawlandshut.algorithmenunddatenstrukturen.insertionsort

import org.junit.Test
import java.util.*
import java.util.stream.Collectors

class InsertionSortTest {

    @Test
    fun test_insertionsort_time_1_million_elements() {
        val list = Random().ints().limit(1_000_000).boxed().collect(Collectors.toList())

        val start = System.nanoTime()
        insertionsort(list)
        val time = System.nanoTime() - start

        println("${time / 1_000_000_000.toDouble()} s")
    }

    @Test
    fun test_insertionsort_time_10_million_elements() {
        val list = Random().ints().limit(10_000_000).boxed().collect(Collectors.toList())

        val start = System.nanoTime()
        insertionsort(list)
        val time = System.nanoTime() - start

        println("${time / 1_000_000_000.toDouble()} s")
    }
}