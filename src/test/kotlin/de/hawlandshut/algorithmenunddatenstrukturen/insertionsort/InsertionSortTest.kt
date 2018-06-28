package de.hawlandshut.algorithmenunddatenstrukturen.insertionsort

import de.hawlandshut.algorithmenunddatenstrukturen.common.testSort
import org.junit.Test

class InsertionSortTest {

    @Test
    fun test_common(){
        testSort { insertionsort(it) }
    }
}