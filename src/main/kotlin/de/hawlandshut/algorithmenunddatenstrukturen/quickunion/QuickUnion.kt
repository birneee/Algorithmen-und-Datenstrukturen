package de.hawlandshut.algorithmenunddatenstrukturen.quickunion

fun quickUnion(vertices: List<Pair<Int, Int>>, u : Int, v : Int) : Boolean{
    val repr = generateQuickUnionTree(vertices)
    return isConnected(repr, u, v)
}

fun generateQuickUnionTree(vertices: List<Pair<Int, Int>>) : IntArray {
    val nodeCount = (vertices.flatMap { it.toList() }.max() ?: 0) + 1
    val repr = IntArray(nodeCount)

    (0 until nodeCount).forEach { repr[it] = it }

    vertices.forEach({
        val root1 = findRoot(repr, it.first)
        val root2 = findRoot(repr, it.second)
        if(root1 != root2){
            repr[root1] = root2
        }
    })

    return repr
}

fun isConnected(repr: IntArray, u : Int, v : Int) = findRoot(repr, u) == findRoot(repr, v)

fun randomGraph(edgeCount : Int, vertexCount : Int) : List<Pair<Int,Int>> {
    val vertices = mutableListOf<Pair<Int, Int>>()

    (0 until vertexCount).forEach({
        vertices.add(Pair((Math.random() * edgeCount).toInt(), (Math.random() * edgeCount).toInt()))
    })

    return vertices
}

private fun findRoot(repr : IntArray, node : Int) : Int{
    var root = node
    while(repr[root] != root){
        root = repr[root]
    }
    return root;
}