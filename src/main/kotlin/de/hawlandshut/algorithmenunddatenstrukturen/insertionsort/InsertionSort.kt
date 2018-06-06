package de.hawlandshut.algorithmenunddatenstrukturen.insertionsort

fun <T : Comparable<T>> insertionsort(list : MutableList<T>){
    for(i in 1..list.size - 1) {
        var j = i - 1
        val key = list[i]
        while(j >= 0 && list[j] > key){
            list[j + 1] = list[j]
            j--
        }
        list[j + 1] = key
    }
}