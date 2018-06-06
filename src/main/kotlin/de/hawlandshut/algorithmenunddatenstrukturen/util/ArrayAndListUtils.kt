package de.hawlandshut.algorithmenunddatenstrukturen.util

fun <T> MutableList<T>.swap(index1 : Int, index2 : Int){
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

fun <T> Array<T>.swap(index1 : Int, index2 : Int){
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

fun <T> List<T>?.getOrEmpty() : List<T> = this ?: emptyList()