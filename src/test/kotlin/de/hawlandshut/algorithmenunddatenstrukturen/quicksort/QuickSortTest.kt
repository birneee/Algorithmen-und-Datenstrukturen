package de.hawlandshut.algorithmenunddatenstrukturen.quicksort


import org.junit.Assert.assertEquals
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
    fun test_quicksort_random_intList(){
        var list = Random().ints().limit(100).toArray().asList()
        val list2 = ArrayList(list)

        list = list.sorted()
        quickSort(list2)

        assertEquals(list, list2)
    }
}