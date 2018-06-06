package de.hawlandshut.algorithmenunddatenstrukturen.heapsort

fun <T : Comparable<T>> checkHeapConditionMax(items : List<T>) : Boolean{

    for(i in 0 .. items.size/2){
        if(!checkHeapConditionMax(items, i)){
            return false
        }
    }

    return true
}

fun <T : Comparable<T>> checkHeapConditionMin(items : List<T>) : Boolean{

    for(i in 0 .. items.size/2){
        if(!checkHeapConditionMin(items, i)){
            return false
        }
    }

    return true
}

fun <T : Comparable<T>> checkHeapConditionMax(items : List<T>, pos : Int) : Boolean {
    var pos = pos + 1 // to one based index
    if(2 * pos <= items.size && items.get1Based(pos) < items.get1Based(2 * pos)){
        return false
    }
    if(2 * pos + 1 <= items.size && items.get1Based(pos) < items.get1Based(2 * pos + 1)){
        return false
    }
    return true
}

fun <T : Comparable<T>> checkHeapConditionMin(items : List<T>, pos : Int) : Boolean {
    var pos = pos + 1 // to one based index
    if(2 * pos <= items.size && items.get1Based(pos) > items.get1Based(2 * pos)){
        return false
    }
    if(2 * pos + 1 <= items.size && items.get1Based(pos) > items.get1Based(2 * pos + 1)){
        return false
    }
    return true
}

fun <T : Comparable<T>> heapifyMin(items: MutableList<T>, pos : Int = 0){
    var pos = pos + 1 // to one based index
    var smallestElemPos = pos
    // left
    if(2 * pos <= items.size && items.get1Based(2 * pos) < items.get1Based(pos)){
        smallestElemPos = 2 * pos
    }
    // right
    if(2 * pos + 1 <= items.size && items.get1Based(2 * pos + 1) < items.get1Based(smallestElemPos)){
        smallestElemPos = 2 * pos + 1
    }
    if(smallestElemPos != pos){
        items.swap1Based(pos, smallestElemPos)
        heapifyMin(items, smallestElemPos - 1) // smallestElemPos to zero based index
    }
}

fun <T : Comparable<T>> heapifyMax(items: MutableList<T>, pos : Int = 0){
    var pos = pos + 1 // to one based index
    var largestElemPos = pos
    // left
    if(2 * pos <= items.size && items.get1Based(2 * pos) > items.get1Based(pos)){
        largestElemPos = 2 * pos
    }
    // right
    if(2 * pos + 1 <= items.size && items.get1Based(2 * pos + 1) > items.get1Based(largestElemPos)){
        largestElemPos = 2 * pos + 1
    }
    if(largestElemPos != pos){
        items.swap1Based(pos, largestElemPos)
        heapifyMax(items, largestElemPos - 1) // smallestElemPos to zero based index
    }
}

/**
 * Heap condition min has to be true on items
 */
fun <T: Comparable<T>> decreaseKey(items: MutableList<T>, pos : Int, value : T){
    var pos = pos + 1 // to one based index
    if(value > items.get1Based(pos))
        throw IllegalArgumentException("Value is too small")
    items.set1Based(pos, value)
    while(pos > 1 && items.get1Based(pos / 2) > items.get1Based(pos)){
        items.swap1Based(pos / 2, pos)
        pos = pos / 2
    }
}

/**
 * heap max condition has to be true<br/>
 * remove and return the max item<br/>
 * the heap condition is restored after removal
 * @return max
 */
fun <T: Comparable<T>> extractMax(items : MutableList<T>) : T{
    if(items.size == 0) throw IllegalArgumentException("Heap is empty")
    val max = items[0]
    items[0] = items[items.size]
    items.removeAt(items.size)
    heapifyMax(items, 0)
    return max
}

/**
 * heap min condition has to be true<br/>
 * remove and return the min item<br/>
 * the heap condition is restored after removal
 * @return min
 */
fun <T: Comparable<T>> extractMin(items : MutableList<T>) : T{
    if(items.size == 0) throw IllegalArgumentException("Heap is empty")
    val min = items[0]
    items[0] = items[items.size]
    items.removeAt(items.size)
    heapifyMin(items, 0)
    return min
}

/**
 * Get value of position<br/>
 * first index is 1
 */
private fun <T> List<T>.get1Based(index : Int) : T{
    return this[index - 1]
}

/**
 * Set value of position<br/>
 * first index is 1
 */
private fun <T> MutableList<T>.set1Based(index : Int, value : T){
    this[index - 1] = value
}

/**
 * Swap values<br/>
 * first index is 1
 */
private fun <T> MutableList<T>.swap1Based(index1 : Int, index2 : Int){
    val tmp = this[index1 - 1]
    this[index1 - 1] = this[index2 - 1]
    this[index2 - 1] = tmp
}