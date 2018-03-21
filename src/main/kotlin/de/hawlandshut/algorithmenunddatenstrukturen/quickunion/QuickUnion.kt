package algodata.quickunion

fun randomGraph(edgeCount : Int, verticeCount : Int) : Graph {
    val vertices = mutableListOf<Pair<Int, Int>>()

    (0 until verticeCount).forEach({
        vertices.add(Pair((Math.random() * edgeCount).toInt(), (Math.random() * edgeCount).toInt()))
    })

    return Graph(vertices)
}

class Graph {
    val vertices: MutableList<Pair<Int, Int>>

    constructor(vertices: MutableList<Pair<Int, Int>>) {
        this.vertices = vertices
    }

}

class QuickUnionTree{

    constructor(graph: Graph){

    }

    fun isConnected(e1 : Edge, e2 : Edge) = e1.root == e2.root

    class Edge {
        var repr : Edge = this
        val id: Int

        constructor(id : Int){
            this.id = id
        }

        constructor(id : Int, repr : Edge){
            this.id = id
            this.repr = repr
        }

        val root : Edge = if(repr == this) this else repr.root
    }
}
