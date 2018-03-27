package de.hawlandshut.algorithmenunddatenstrukturen.quickunion

import org.junit.Assert.*
import org.junit.Test

class QuickUnionTest{

    @Test
    fun test_quickUnion(){
        val vertices = listOf(
                0 to 2,
                1 to 2,
                3 to 4,
                4 to 5,
                5 to 6,
                5 to 7
        )

        assertFalse(quickUnion(vertices, 0, 3))
        assertTrue(quickUnion(vertices, 0, 2))
        assertTrue(quickUnion(vertices, 7, 3))
    }

}