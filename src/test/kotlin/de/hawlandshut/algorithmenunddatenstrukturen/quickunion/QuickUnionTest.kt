package de.hawlandshut.algorithmenunddatenstrukturen.quickunion

import de.hawlandshut.algorithmenunddatenstrukturen.util.readVerticesFromFile
import org.junit.Assert.*
import org.junit.Test
import java.io.IOException
import java.io.BufferedReader
import java.io.FileReader
import java.io.InputStreamReader
import java.util.ArrayList
import java.util.stream.Collectors


class QuickUnionTest{

    @Test
    fun test_quickUnion(){
        val vertices = listOf(
                0 to 2,
                1 to 2,
                3 to 4,
                4 to 5,
                5 to 6,
                5 to 7
        )

        assertFalse(quickUnion(vertices, 0, 3))
        assertTrue(quickUnion(vertices, 0, 2))
        assertTrue(quickUnion(vertices, 7, 3))
    }


    fun adjacencyListToString(adjacencyList : List<Map<Int, IntArray>>) : String{
        val sb = StringBuilder()

        adjacencyList.forEachIndexed{ index, edges ->
                    sb.appendln("UnionComponent ${index + 1}:")
                    edges.forEach { edge ->
                        sb.append("${edge.key}: {")
                        sb.append(edge.value.joinToString(", "))
                        sb.appendln("}")
                    }
                    sb.appendln()
                }

        return sb.toString()
    }

    /**
     * Only check if code is running<br/>
     * Output is not checked
     */
    @Test
    fun test_adjacencyList(){
        val actual1 = adjacencyListToString(generateAdjacencyList(readVerticesFromFile("Net1.txt")))
        val actual2 = adjacencyListToString(generateAdjacencyList(readVerticesFromFile("Net2.txt")))
        val actual3 = adjacencyListToString(generateAdjacencyList(readVerticesFromFile("Net3.txt")))
        val actual4 = adjacencyListToString(generateAdjacencyList(readVerticesFromFile("Net4.txt")))
        val actual5 = adjacencyListToString(generateAdjacencyList(readVerticesFromFile("Net5.txt")))

        println("1:\n$actual1")
        println("2:\n$actual2")
        println("3:\n$actual3")
        println("4:\n$actual4")
        println("5:\n$actual5")
    }

}