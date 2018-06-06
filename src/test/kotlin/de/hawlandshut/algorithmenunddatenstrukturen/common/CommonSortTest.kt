package de.hawlandshut.algorithmenunddatenstrukturen.common

import com.google.common.collect.Ordering
import org.junit.Assert.assertTrue
import java.util.*
import java.util.stream.Collectors

typealias Sorter<T> = (MutableList<T>) -> Unit

fun testSort(sorter : Sorter<Int>){
    testSortEmpty(sorter)
    testSort100RandomInt(sorter)
    testSortOneElement(sorter)
    testSortOnlyEqualElements(sorter)
}


fun testSortEmpty(sorter : Sorter<Int>){
    val list = mutableListOf<Int>()
    sorter.invoke(list)
    assertTrue(Ordering.natural<Int>().isOrdered(list))
}

fun testSort100RandomInt(sorter : Sorter<Int>){
    val list = Random().ints().boxed().limit(100).collect(Collectors.toList())
    sorter.invoke(list)
    assertTrue(Ordering.natural<Int>().isOrdered(list))
}

fun testSortOneElement(sorter : Sorter<Int>){
    val list = mutableListOf(Random().nextInt())
    sorter.invoke(list)
    assertTrue(Ordering.natural<Int>().isOrdered(list))
}

fun testSortOnlyEqualElements(sorter : Sorter<Int>){
    val value = Random().nextInt()
    val list = generateSequence { value }.take(100).toMutableList()
    sorter.invoke(list)
    assertTrue(Ordering.natural<Int>().isOrdered(list))
}