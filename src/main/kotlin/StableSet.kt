fun Graph.maximumStableSet(): Set<String> {
    var bestSet = emptySet<String>()
    val currentSet = mutableSetOf<String>()

    fun bound(vertices: List<String>): Int {
        return currentSet.size + vertices.size
    }

    fun branch(vertices: List<String>) {
        if (vertices.isEmpty()) {
            if (currentSet.size > bestSet.size) {
                bestSet = currentSet.toSet()
            }
            return
        }

        if (bound(vertices) <= bestSet.size) {
            return
        }

        val vertex = vertices[0]
        val remainingVertices = vertices.subList(1, vertices.size)

        if (currentSet.none { it in links[vertex]!! }) {
            currentSet.add(vertex)
            branch(remainingVertices)
            currentSet.remove(vertex)
        }

        branch(remainingVertices)
    }

    branch(links.keys.toList())
    return bestSet
}