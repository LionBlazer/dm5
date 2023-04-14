import kotlin.math.max
import kotlin.math.min

private fun Graph.minimumVertexCover(vertexIndex: Int, cover: HashSet<String>, remainingEdges: HashSet<Pair<String, String>>): Int {
    if (remainingEdges.isEmpty()) {
        return cover.size
    }

    if (vertexIndex >= links.keys.size) {
        return Int.MAX_VALUE
    }

    val vertex = links.keys.elementAt(vertexIndex)

    val coverWithCurrent = cover.clone() as HashSet<String>
    coverWithCurrent.add(vertex)
    val remainingEdgesWithCurrent = remainingEdges.clone() as HashSet<Pair<String, String>>
    remainingEdgesWithCurrent.removeIf { it.first == vertex || it.second == vertex }

    return min(
        minimumVertexCover(vertexIndex + 1, cover, remainingEdges),
        minimumVertexCover(vertexIndex + 1, coverWithCurrent, remainingEdgesWithCurrent)
    )
}

fun Graph.minimumVertexCover(): Int {
    val edges = HashSet<Pair<String, String>>()
    links.forEach { (vertex, adjacentVertices) ->
        adjacentVertices.forEach { adjacentVertex ->
            edges.add(Pair(listOf(vertex, adjacentVertex).minOf { it }, listOf(vertex, adjacentVertex).maxOf { it }))
        }
    }
    return minimumVertexCover(0, HashSet<String>(), edges)
}