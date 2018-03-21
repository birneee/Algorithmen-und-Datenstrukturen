package de.hawlandshut.algorithmenunddatenstrukturen.quicksort

import org.junit.Assert.assertEquals
import org.junit.Test

class QuickSortTest{

    @Test
    fun test_quicksort_intList(){
        val list = mutableListOf(1, 6, 5, 7, -3)
        val expected = listOf(-3, 1, 5, 6, 7)

        quickSort(list)

        assertEquals(expected, list)
    }

}