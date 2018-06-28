package de.hawlandshut.algorithmenunddatenstrukturen.common

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.util.stream.Collectors

data class WeightedEdge(val vertex1 : Int, val vertex2 : Int, val weight : Int)

/**
 * only vertex1 is connected to vertex2<br/>
 * but not vice versa
 */
data class DirectedWeightedEdge(val vertex1 : Int, val vertex2 : Int, val weight : Int)

data class Edge(val vertex1 : Int, val vertex2 : Int)

data class WeightedGraph(private val list : List<WeightedEdge>) : List<WeightedEdge> by list

data class Graph(private val list : List<Edge>) : List<Edge> by list

data class DirectedGraph(private val list : List<Edge>) : List<Edge> by list

data class DirectedWeightedGraph(private val list : List<DirectedWeightedEdge>) : List<DirectedWeightedEdge> by list

fun List<DirectedWeightedEdge>.toDirectedWeightedGraph() = DirectedWeightedGraph(this)

fun directedWeightedGraphFromFile(file : File) : DirectedWeightedGraph{
    val reader = BufferedReader(FileReader(file))
    return reader
            .lines()
            .filter{ it.isBlank().not()  }
            .filter { it.first() != '#' }
            .map { it.split(" ") }
            .map { DirectedWeightedEdge(
                    it[0].toInt(),
                    it[1].toInt(),
                    it[2].toInt()
            ) }
            .collect(Collectors.toList())
            .toDirectedWeightedGraph()
}