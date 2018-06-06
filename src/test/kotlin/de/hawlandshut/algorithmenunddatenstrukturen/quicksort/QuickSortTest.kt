package de.hawlandshut.algorithmenunddatenstrukturen.quicksort


import com.google.common.collect.Ordering
import de.hawlandshut.algorithmenunddatenstrukturen.common.testSort
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.util.*
import java.util.stream.Collectors

class QuickSortTest{

    @Test
    fun test_quicksort_intList(){
        val list = mutableListOf(1, 6, 5, 7, -3)
        val expected = listOf(-3, 1, 5, 6, 7)

        quickSort(list)

        assertEquals(expected, list)
    }

    @Test
    fun test_common(){
        testSort { quickSort(it) }
    }

    @Test
    fun test_quicksort_random_intList(){
        val list = Random().ints().limit(100).boxed().collect(Collectors.toList())

        quickSort(list)

        assertTrue(Ordering.natural<Int>().isOrdered(list))
    }

    @Test
    fun test_quicksort_1_million_elements(){
        val list = Random().ints().limit(1_000_000).boxed().collect(Collectors.toList())

        val start = System.nanoTime()
        quickSort(list)
        val time = System.nanoTime() - start

        println("${time/1_000_000_000.toDouble()} s")

        assertTrue(Ordering.natural<Int>().isOrdered(list))
    }

    @Test
    fun test_quicksort_10_million_elements(){
        val list = Random().ints().limit(10_000_000).boxed().collect(Collectors.toList())

        val start = System.nanoTime()
        quickSort(list)
        val time = System.nanoTime() - start

        println("${time/1_000_000_000.toDouble()} s")

        assertTrue(Ordering.natural<Int>().isOrdered(list))
    }

    @Test
    fun test_quicksort_with_insertionsort_1_million_elements(){
        val list = Random().ints().limit(1_000_000).boxed().collect(Collectors.toList())

        val start = System.nanoTime()
        quicksortWithInsertionsort(list, 70)
        val time = System.nanoTime() - start

        println("${time/1_000_000_000.toDouble()} s")

        assertTrue(Ordering.natural<Int>().isOrdered(list))
    }

    @Test
    fun test_quicksort_with_insertionsort_10_million_elements(){
        val list = Random().ints().limit(10_000_000).boxed().collect(Collectors.toList())

        val start = System.nanoTime()
        quicksortWithInsertionsort(list, 70)
        val time = System.nanoTime() - start

        println("${time/1_000_000_000.toDouble()} s")

        assertTrue(Ordering.natural<Int>().isOrdered(list))
    }

    @Test
    fun test_quicksortFind(){
        val list = Random().ints().limit(1_000).boxed().collect(Collectors.toList())
        val value = quicksortFind(list, 20)
        list.sort()
        assertEquals(list[20], value)
    }


}