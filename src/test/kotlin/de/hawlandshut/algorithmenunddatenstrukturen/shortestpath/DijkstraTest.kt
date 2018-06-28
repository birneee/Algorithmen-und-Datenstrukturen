package de.hawlandshut.algorithmenunddatenstrukturen.shortestpath

import de.hawlandshut.algorithmenunddatenstrukturen.common.directedWeightedGraphFromFile
import de.hawlandshut.algorithmenunddatenstrukturen.common.fileFromResources
import junit.framework.TestCase.assertEquals
import org.junit.Test

class DijkstraTest{

    @Test
    fun test_directedWeightedGraph(){

        val graph = directedWeightedGraphFromFile(fileFromResources("DirectedWeightedGraph1"))
        val paths = shortestPathDijkstra(graph, 0)
        paths.print()

        assertEquals("B", 11, paths[1]!!.distance)
        assertEquals("C",7, paths[2]!!.distance)
        assertEquals("D",12, paths[3]!!.distance)
        assertEquals("E",14, paths[4]!!.distance)
        assertEquals("F",19, paths[5]!!.distance)
        assertEquals("G",18, paths[6]!!.distance)
        assertEquals("H",22, paths[7]!!.distance)

        assertEquals("B", 2, paths[1]!!.predecessor)
        assertEquals("C",0, paths[2]!!.predecessor)
        assertEquals("D",0, paths[3]!!.predecessor)
        assertEquals("E",0, paths[4]!!.predecessor)
        assertEquals("F",4, paths[5]!!.predecessor)
        assertEquals("G",3, paths[6]!!.predecessor)
        assertEquals("H",6, paths[7]!!.predecessor)
    }

}