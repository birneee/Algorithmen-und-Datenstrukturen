package de.hawlandshut.algorithmenunddatenstrukturen.bubblesort

import org.junit.Assert.assertEquals
import org.junit.Test

class BubbleSortTest{

    @Test
    fun test_bubblesort_intList(){
        val list = mutableListOf(1, 6, 5, 7, -3)
        val expected = listOf(-3, 1, 5, 6, 7)

        bubbleSort(list)

        assertEquals(expected, list)
    }

}