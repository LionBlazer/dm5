fun Graph.maximumClique(): Set<String> {
    val nodes = links.keys.toList()
    var maxClique: Set<String> = emptySet()

    for (node in nodes) {
        val subsetsNeighbor = getAllSubsetsNeighbor(node)
        for (untilClique in subsetsNeighbor) {
            val preClique = untilClique + node
            if (isClique(preClique) && preClique.size >= maxClique.size) {
                maxClique = preClique
            }
        }
    }
    return maxClique
}

private fun Graph.getAllSubsetsNeighbor(node: String): Set<Set<String>> {
    val allSubSets = HashSet<Set<String>>()

    allSubSets.addAll(links[node]!!.map { setOf(it) })

    //2 length
    for (neighbor in links[node]!!) {
        for (neighbor2 in links[node]!!) {
            val set = hashSetOf(neighbor, neighbor2)
            if (set.size == 2)
                allSubSets += set
        }
    }

    //3 length
    for (neighbor in links[node]!!) {
        for (neighbor2 in links[node]!!) {
            for (neighbor3 in links[node]!!) {
                val set = hashSetOf(neighbor, neighbor2, neighbor3)
                if (set.size == 3)
                    allSubSets += set
            }
        }
    }

    //4 length
    for (neighbor in links[node]!!) {
        for (neighbor2 in links[node]!!) {
            for (neighbor3 in links[node]!!) {
                for (neighbor4 in links[node]!!) {
                    val set = hashSetOf(neighbor, neighbor2, neighbor3, neighbor4)
                    if (set.size == 4)
                        allSubSets += set
                }
            }
        }
    }

    //5 length
    for (neighbor in links[node]!!) {
        for (neighbor2 in links[node]!!) {
            for (neighbor3 in links[node]!!) {
                for (neighbor4 in links[node]!!) {
                    for (neighbor5 in links[node]!!) {
                        val set = hashSetOf(neighbor, neighbor2, neighbor3, neighbor4, neighbor5)
                        if (set.size == 5)
                            allSubSets += set
                    }
                }
            }
        }
    }




    return allSubSets
}

private fun Graph.isClique(subset: Set<String>): Boolean {
    for (node1 in subset) {
        for (node2 in subset) {
            if (node1 != node2 && !links.getValue(node1).contains(node2)) {
                return false
            }
        }
    }
    return true
}