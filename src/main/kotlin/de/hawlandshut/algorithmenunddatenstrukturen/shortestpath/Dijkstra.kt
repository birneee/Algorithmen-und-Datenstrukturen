package de.hawlandshut.algorithmenunddatenstrukturen.shortestpath

import de.hawlandshut.algorithmenunddatenstrukturen.adjacencyList.DirectedWeightedAdjacencyList
import de.hawlandshut.algorithmenunddatenstrukturen.adjacencyList.WeightedAdjacencyList
import de.hawlandshut.algorithmenunddatenstrukturen.adjacencyList.generateAdjacencyList
import de.hawlandshut.algorithmenunddatenstrukturen.common.DirectedWeightedGraph
import de.hawlandshut.algorithmenunddatenstrukturen.common.WeightedGraph
import de.hawlandshut.algorithmenunddatenstrukturen.heapsort.extractMin
import de.hawlandshut.algorithmenunddatenstrukturen.heapsort.heapifyMin
import de.hawlandshut.algorithmenunddatenstrukturen.util.getOrEmpty

/**
 * Shortest path to a start vertex<br/>
 * start vertex itself can not represented as ShortestPath
 */
data class ShortestPath(val distance : Int, val predecessor : Int)

fun Map<Int, ShortestPath>.print(){
    for((v, path) in this){
        println("$v: distance ${path.distance}, predecessor ${path.predecessor}")
    }
}

/**
 * @return predecessors and distance to startVertex
 */
fun shortestPathDijkstra(graph : WeightedGraph, startVertex : Int) : Map<Int, ShortestPath>{
    return shortestPathDijkstra(
            generateAdjacencyList(graph),
            startVertex
    )
}

/**
 * @return predecessors and distance to startVertex
 */
fun shortestPathDijkstra(graph : DirectedWeightedGraph, startVertex : Int) : Map<Int, ShortestPath>{
    return shortestPathDijkstra(
            generateAdjacencyList(graph),
            startVertex
    )
}



/**
 * @return predecessors and distance to startVertex
 */
fun shortestPathDijkstra(adjacencyList : WeightedAdjacencyList, startVertex : Int) : Map<Int, ShortestPath>{
    val dist = mutableMapOf<Int, Int>()
    val pred = mutableMapOf<Int, Int>()
    for(v in adjacencyList.keys){
        dist[v] = Int.MAX_VALUE
    }
    dist[startVertex] = 0
    val pendingVertices = adjacencyList.keys.toMutableList()
    heapifyMin(pendingVertices)
    while(pendingVertices.isEmpty().not()){
        val u = extractMin(pendingVertices)
        for((v, weight) in adjacencyList[u].getOrEmpty()){
            if(dist[v]!! > dist[u]!! + weight){
                pred[v] = u
            }
        }
    }

    return adjacencyList.mapValues { (v, _) -> ShortestPath(dist[v]!!, pred[v]!!) }
}

/**
 * start vertex itself is not contained in result
 * @return predecessors and distance to startVertex
 */
fun shortestPathDijkstra(adjacencyList : DirectedWeightedAdjacencyList, startVertex : Int) : Map<Int, ShortestPath>{
    val dist = mutableMapOf<Int, Int>()
    val pred = mutableMapOf<Int, Int>()
    for(v in adjacencyList.keys){
        dist[v] = Int.MAX_VALUE
    }
    dist[startVertex] = 0
    val pendingVertices = adjacencyList.keys.toMutableList()
    heapifyMin(pendingVertices)
    while(pendingVertices.isEmpty().not()){
        val u = extractMin(pendingVertices)
        for((v, weight) in adjacencyList[u].getOrEmpty()){
            if(dist[v]!! > dist[u]!! + weight){
                dist[v] = dist[u]!! + weight
                pred[v] = u
            }
        }
    }

    return adjacencyList
            .filter { (v, _) -> v != startVertex } // do not include start vertex itself
            .mapValues { (v, _) -> ShortestPath(dist[v]!!, pred[v]!!) }
}