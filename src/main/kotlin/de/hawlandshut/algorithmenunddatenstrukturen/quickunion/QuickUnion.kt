package de.hawlandshut.algorithmenunddatenstrukturen.quickunion

fun quickUnion(vertices: List<Pair<Int, Int>>, u : Int, v : Int) : Boolean{
    val repr = generateQuickUnionTree(vertices)
    return isConnected(repr, u, v)
}

fun generateQuickUnionTree(vertices: List<Pair<Int, Int>>) : IntArray {
    val edgeCount = (vertices.flatMap { it.toList() }.max() ?: 0) + 1
    val repr = IntArray(edgeCount)

    (0 until edgeCount).forEach { repr[it] = it }

    vertices.forEach({
        val root1 = findRoot(repr, it.first)
        val root2 = findRoot(repr, it.second)
        if(root1 != root2){
            repr[root1] = root2
        }
    })

    return repr
}

/**
 * check if two edges are connected in the graph<br/>
 * connection are transitive
 */
fun isConnected(repr: IntArray, u : Int, v : Int) = findRoot(repr, u) == findRoot(repr, v)

/**
 * generate a list which represent all connected groups.<br/>
 * these groups contain all edges with it connections
 */
fun generateAdjacencyList(vertices: List<Pair<Int, Int>>) : List<Map<Int, IntArray>>{
    val repr = generateQuickUnionTree(vertices)
    val components = mutableListOf<Map<Int, IntArray>>()

    repr.indices
            .groupBy { edge -> findRoot(repr, edge) }
            .forEach { _, edges ->
                val component = mutableMapOf<Int, IntArray>()
                edges.forEach { edge ->
                    component[edge] = getDirectConnections(vertices, edge)
                }
                components.add(component)
            }

    return components
}

fun randomGraph(edgeCount : Int, vertexCount : Int) : List<Pair<Int,Int>> {
    val vertices = mutableListOf<Pair<Int, Int>>()

    (0 until vertexCount).forEach({
        vertices.add(Pair((Math.random() * edgeCount).toInt(), (Math.random() * edgeCount).toInt()))
    })

    return vertices
}

private fun getDirectConnections(vertices: List<Pair<Int, Int>>, edge : Int) : IntArray{
    return vertices
            .filter { vertex -> vertex.toList().contains(edge) }
            .map { vertex -> if(vertex.first == edge) vertex.second else vertex.first}
            .toIntArray()
}

private fun findRoot(repr : IntArray, edge : Int) : Int{
    var root = edge
    while(repr[root] != root){
        root = repr[root]
    }
    return root;
}