package de.hawlandshut.algorithmenunddatenstrukturen.quicksort

import de.hawlandshut.algorithmenunddatenstrukturen.insertionsort.insertionsort
import de.hawlandshut.algorithmenunddatenstrukturen.util.swap

fun <T : Comparable<T>>quickSort(items : MutableList<T>, left : Int = 0, right : Int = items.size - 1){
    if(left >= right)
        return

    var pivot = determinePivot(items, left, right)

    pivot = partition(items, pivot, left, right)

    quickSort(items, left, pivot - 1)
    quickSort(items, pivot + 1, right)
}

/**
 * Quick Sort with Insertion Sort<br/>
 * use insertion sort if field parts are smaller than k
 * @param k switch to insertion sort if field parts are smaller than k
 */
fun <T : Comparable<T>> quicksortWithInsertionsort(items : MutableList<T>, k : Int){
    quicksortWithBreak(items, k)
    insertionsort(items)
}

/**
 * Quick Sort with break<br/>
 * which break sorting if field parts are smaller than k
 * @param items to sort
 * @param left bound to sort
 * @param right bound to sort
 * @param k break if field parts are smaller than k
 */
private fun <T : Comparable<T>>quicksortWithBreak(items : MutableList<T>,  k : Int, left : Int = 0, right : Int = items.size - 1){
    if(right - left < k)
        return

    var pivot = determinePivot(items, left, right)

    pivot = partition(items, pivot, left, right)

    quicksortWithBreak(items, k, left, pivot - 1)
    quicksortWithBreak(items, k,pivot + 1, right)
}

/**
 * Find item at position of items if they were sorted
 * @param items where to search
 * @param position
 * @param low lower bound to sort
 * @param high upper bound to sort
 * @return value of element at position
 */
fun <T : Comparable<T>> quicksortFind(items : MutableList<T>, index : Int, left : Int = 0, right : Int = items.size - 1) : T{
    var pivot = determinePivot(items, left, right)

    pivot = partition(items, pivot, left, right)

    if(pivot == index){
        return items[index]
    }
    else if(index < pivot) {
        return quicksortFind(items, index, left, pivot)
    }
    else{
        return quicksortFind(items, index, pivot, right)
    }
}

/**
 * @return new pivot
 */
fun <T: Comparable<T>> partition(items : MutableList<T>, pivot : Int, left : Int, right : Int) : Int{
    var li = left
    var ri = right
    var pivot = pivot

    // swap pivot to with first element
    items.swap(li, pivot)
    pivot = li

    while (li != ri){
        while (items[li] <= items[pivot] && li != ri){
            li++
        }
        while (items[ri] >= items[pivot] && li != ri){
            ri--
        }
        if(li != ri){
            items.swap(li, ri);
        }
    }

    // swap pivot to right place
    if(items[pivot] > items[li]) {
        items.swap(pivot, li)
        return  li
    }
    else {
        items.swap(pivot, li - 1)
        return  li - 1
    }
}

/**
 * Determine index of pivot element
 */
private fun <T : Comparable<T>> determinePivot(items : MutableList<T>, left : Int, right : Int) : Int{
    return left + ((right - left) * Math.random()).toInt()
}