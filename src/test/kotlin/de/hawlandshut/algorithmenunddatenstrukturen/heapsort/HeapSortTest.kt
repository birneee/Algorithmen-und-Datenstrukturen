package de.hawlandshut.algorithmenunddatenstrukturen.heapsort

import org.junit.Assert.*
import org.junit.Test

class HeapSortTest{

    @Test
    fun test_checkHeapCondition(){
        val items = listOf(4, 18, 5, 47, 19, 8, 7, 49, 51, 46)
        val minCondition = checkHeapConditionMin(items)
        assertTrue(minCondition)
        val maxCondition = checkHeapConditionMax(items)
        assertFalse(maxCondition)
    }

    @Test
    fun test_checkHeapConditionMax(){
        val items = listOf(20, 18, 19, 14, 13, 9, 10)
        val condition = checkHeapConditionMax(items)
        assertTrue(condition)
    }

    @Test
    fun test_heapifyMin(){
        val items = mutableListOf(44, 18, 5, 47, 19, 8, 7, 49, 51, 46)
        heapifyMin(items)
        println(items)
        assertTrue(checkHeapConditionMin(items))
    }

    @Test
    fun test_decreaseKey(){
        val items = mutableListOf(2, 18, 5, 47, 19, 8, 7, 49, 51, 46)
        decreaseKey(items, 7, 4)
        println(items)
        assertTrue(checkHeapConditionMin(items))
    }

}