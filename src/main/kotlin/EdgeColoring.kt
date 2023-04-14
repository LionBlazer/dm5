
fun Graph.minimumEdgeColoring(): Map<Pair<String, String>, Int> {
    val edgeColors = mutableMapOf<Pair<String, String>, Int>()
    val vertexColors = mutableMapOf<String, MutableSet<Int>>()

    links.keys.forEach { vertexColors[it] = mutableSetOf() }

    for ((vertex, incidentVertices) in links) {
        for (incidentVertex in incidentVertices) {
            val edge = Pair(vertex, incidentVertex)

            if (edgeColors.containsKey(edge) || edgeColors.containsKey(Pair(incidentVertex, vertex))) {
                continue
            }

            val forbiddenColors = (vertexColors[vertex]!! + vertexColors[incidentVertex]!!).toSet()

            var color = 1
            while (forbiddenColors.contains(color)) {
                color++
            }

            edgeColors[edge] = color
            vertexColors[vertex]!!.add(color)
            vertexColors[incidentVertex]!!.add(color)
        }
    }

    return edgeColors
}