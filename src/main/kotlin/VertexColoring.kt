
fun Graph.minimumVertexColoring(): Map<String, Int> {
    val vertexColors = LinkedHashMap<String, Int>()
    val saturationDegrees = LinkedHashMap<String, Int>()

    links.keys.forEach { vertex ->
        saturationDegrees[vertex] = 0
    }

    while (saturationDegrees.isNotEmpty()) {
        val selectedVertex = saturationDegrees.entries.maxWithOrNull(
            compareBy({ it.value }, { links[it.key]?.size ?: 0 })
        )?.key ?: break

        saturationDegrees.remove(selectedVertex)

        val incidentColors = mutableSetOf<Int>()

        links[selectedVertex]?.forEach { incidentalVertex ->
            vertexColors[incidentalVertex]?.let { color ->
                incidentColors.add(color)
            }
        }

        var color = 1
        while (incidentColors.contains(color)) {
            color++
        }

        vertexColors[selectedVertex] = color

        links[selectedVertex]?.forEach { adjacentVertex ->
            if (!vertexColors.containsKey(adjacentVertex)) {
                val newDegree = saturationDegrees[adjacentVertex]?.inc()
                saturationDegrees[adjacentVertex] = newDegree ?: 1
            }
        }
    }

    return vertexColors
}