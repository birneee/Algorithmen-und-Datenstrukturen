package de.hawlandshut.algorithmenunddatenstrukturen.adjacencyList

import de.hawlandshut.algorithmenunddatenstrukturen.common.DirectedWeightedGraph
import de.hawlandshut.algorithmenunddatenstrukturen.common.WeightedGraph

data class WeightedConnection(val vertex : Int, val weight : Int)

data class DirectedWeightedConnection(val vertex : Int, val weight : Int)

data class DirectedWeightedAdjacencyList(private val map : Map<Int, List<DirectedWeightedConnection>>) : Map<Int, List<DirectedWeightedConnection>> by map


fun Map<Int, List<DirectedWeightedConnection>>.toDirectedWeightedAdjacencyList() = DirectedWeightedAdjacencyList(this)

data class WeightedAdjacencyList(private val map : Map<Int, List<WeightedConnection>>) : Map<Int, List<WeightedConnection>> by map

fun Map<Int, List<WeightedConnection>>.toWeightedAdjacencyList() = WeightedAdjacencyList(this)


data class AdjacencyList(private val map : Map<Int, List<Int>>) : Map<Int, List<Int>> by map

fun AdjacencyList.print(){
    for((v, connections) in this){
        println(v)
        for(connection in connections){
            println("\t<-> $connection")
        }
    }
}

fun WeightedAdjacencyList.print(){
    for((v, connections) in this){
        println(v)
        for((connection, weight) in connections){
            println("\t<$weight> $connection")
        }
    }
}

fun DirectedWeightedAdjacencyList.print(){
    for((v, connections) in this){
        println(v)
        for((connection, weight) in connections){
            println("\t-$weight> $connection")
        }
    }
}

/**
 * generate a set of all vertices associated with a set of its direct connections
 */
fun generateAdjacencyList(graph : DirectedWeightedGraph) : DirectedWeightedAdjacencyList{
    return getVertices(graph)
            .associate { v -> v to getDirectConnections(graph, v) }
            .toDirectedWeightedAdjacencyList()
}

/**
 * generate a set of all vertices associated with a set of its direct connections
 */
fun generateAdjacencyList(graph : WeightedGraph) : WeightedAdjacencyList{
    return getVertices(graph)
            .associate { v -> v to getDirectConnections(graph, v) }
            .toWeightedAdjacencyList()
}

private fun getDirectConnections(graph: WeightedGraph, vertex : Int) : List<WeightedConnection>{
    return graph
            .filter { (v1, v2, _) -> vertex == v1 || vertex == v2 }
            .map {
                (v1, v2, weight) -> WeightedConnection(
                    if(v1 == vertex) v2 else v1,
                    weight
                )
            }
}

private fun getDirectConnections(graph: DirectedWeightedGraph, vertex : Int) : List<DirectedWeightedConnection>{
    return graph
            .filter { (v1, _, _) -> vertex == v1}
            .map {
                (_, v2, weight) -> DirectedWeightedConnection(
                    v2,
                    weight
            )
            }
}

private fun getVertices(graph: WeightedGraph) : List<Int> {
    return graph
            .asSequence()
            .flatMap { (v1, v2, _) -> sequenceOf(v1, v2) }
            .distinct()
            .toList()
}

private fun getVertices(graph: DirectedWeightedGraph) : List<Int> {
    return graph
            .asSequence()
            .flatMap { (v1, v2, _) -> sequenceOf(v1, v2) }
            .distinct()
            .toList()
}