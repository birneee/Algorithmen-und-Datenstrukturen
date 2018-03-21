package de.hawlandshut.algorithmenunddatenstrukturen.quicksort

fun <T : Comparable<T>>quickSort(items : MutableList<T>){
    if (items.size < 2)
        return

    quickSort(items, 0, items.size - 1)
}

private fun <T : Comparable<T>>quickSort(items : MutableList<T>, low : Int, high : Int){
    if (items.size < 2)
        return

    if(low >= high)
        return

    val pivot = items[low + (high - low) / 2]
    var i = low
    var j = high

    while (i <= j){
        while (items[i] < pivot)
            i++
        while (items[j] > pivot)
            j--
        if(i <= j){
            val tmp = items[i]
            items[i] = items[j]
            items[j] = tmp
            i++
            j--
        }
    }

    if(low < j)
        quickSort(items, low, j)

    if(high > i)
        quickSort(items, i, high)

}

fun <T : Comparable<T>>quickSort(items : Array<T>){
    if (items.size < 2)
        return

    quickSort(items, 0, items.size - 1)
}

private fun <T : Comparable<T>>quickSort(items : Array<T>, low : Int, high : Int){
    if (items.size < 2)
        return

    if(low >= high)
        return

    val pivot = items[low + (high - low) / 2]
    var i = low
    var j = high

    while (i <= j){
        while (items[i] < pivot)
            i++
        while (items[j] > pivot)
            j--
        if(i <= j){
            val tmp = items[i]
            items[i] = items[j]
            items[j] = tmp
            i++
            j--
        }
    }

    if(low < j)
        quickSort(items, low, j)

    if(high > i)
        quickSort(items, i, high)

}