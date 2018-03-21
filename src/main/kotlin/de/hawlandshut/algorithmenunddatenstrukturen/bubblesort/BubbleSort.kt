package de.hawlandshut.algorithmenunddatenstrukturen.bubblesort

fun <T : Comparable<T>>bubbleSort(items : MutableList<T>){
    var swapped: Boolean
    do {
       swapped = false
        for(i in 1 until items.size){
            if(items[i] < items[i -1]){
                val tmp = items[i]
                items[i] = items[i - 1]
                items[i - 1] = tmp
                swapped = true
            }
        }
    } while (swapped)
}

fun <T : Comparable<T>>bubbleSort(items : Array<T>){
    var swapped: Boolean
    do {
        swapped = false
        for(i in 1 until items.size){
            if(items[i] < items[i -1]){
                val tmp = items[i]
                items[i] = items[i - 1]
                items[i - 1] = tmp
                swapped = true
            }
        }
    } while (swapped)
}