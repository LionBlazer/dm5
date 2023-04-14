import java.util.*

fun main(args: Array<String>) {
    println("Hello World!")

    val rawLines = g.split("\n".toRegex()).map { it.trim() }
    val links = HashMap<String, HashSet<String>>()
    var countL = 0

    for (line in rawLines) {
        val link = line.split("--".toRegex()).map { it.trim() }
        val current = links.computeIfAbsent(link[0]) { HashSet() }
        if (link.size == 2) {
            current.add(link[1])
            val reversed = links.computeIfAbsent(link[1]) { HashSet() }
            reversed.add(link[0])
            countL++
        }
    }

    val graph = Graph(links)

    val minimumVertexColoring = graph.minimumVertexColoring()
    val minimumEdgeColoring = graph.minimumEdgeColoring()
    val maximumClique = graph.maximumClique()
    val maximumStableSet = graph.maximumStableSet()
    val minimumVertexCover = graph.minimumVertexCover()
    println()
}

private const val g = "Russia -- Norway\n" +
        "\tRussia -- Finland\n" +
        "\tRussia -- Estonia\n" +
        "\tRussia -- Latvia\n" +
        "\tRussia -- Belarus\n" +
        "\tRussia -- Lithuania\n" +
        "\tRussia -- Poland\n" +
        "\tRussia -- Ukraine\n" +
        "\tRussia -- Georgia\n" +
        "\tNorway -- Sweden\n" +
        "\tNorway -- Finland\n" +
        "\tFinland -- Sweden\n" +
        "\tSweden -- Denmark\n" +
        "\tEstonia -- Latvia\n" +
        "\tLatvia -- Lithuania\n" +
        "\tLatvia -- Belarus\n" +
        "\tBelarus -- Lithuania\n" +
        "\tBelarus -- Poland\n" +
        "\tBelarus -- Ukraine\n" +
        "\tLithuania -- Poland\n" +
        "\tUkraine -- Poland\n" +
        "\tUkraine -- Slovakia\n" +
        "\tUkraine -- Hungary\n" +
        "\tUkraine -- Romania\n" +
        "\tUkraine -- Moldova\n" +
        "\tGeorgia -- Armenia\n" +
        "\tGeorgia -- Turkey\n" +
        "\tArmenia -- Turkey\n" +
        "\tMoldova -- Romania\n" +
        "\tPoland -- Germany\n" +
        "\tPoland -- Czech\n" +
        "\tPoland -- Slovakia\n" +
        "\tDenmark -- Germany\n" +
        "\tGermany -- Netherlands\n" +
        "\tGermany -- Belgium\n" +
        "\tGermany -- Luxembourg\n" +
        "\tGermany -- France\n" +
        "\tGermany -- Switzerland\n" +
        "\tGermany -- Austria\n" +
        "\tGermany -- Czech\n" +
        "\tCzech -- Austria\n" +
        "\tCzech -- Slovakia\n" +
        "\tSlovakia -- Austria\n" +
        "\tSlovakia -- Hungary\n" +
        "\tRomania -- Hungary\n" +
        "\tRomania -- Serbia\n" +
        "\tRomania -- Bulgaria\n" +
        "\tBulgaria -- Serbia\n" +
        "\tBulgaria -- Macedonia\n" +
        "\tBulgaria -- Greece\n" +
        "\tBulgaria -- Turkey\n" +
        "\tTurkey -- Greece\n" +
        "\tNetherlands -- Belgium\n" +
        "\tBelgium -- France\n" +
        "\tBelgium -- Luxembourg\n" +
        "\tLuxembourg -- France\n" +
        "\tAustria -- Switzerland\n" +
        "\tAustria -- Italy\n" +
        "\tAustria -- Slovenia\n" +
        "\tAustria -- Hungary\n" +
        "\tHungary -- Slovenia\n" +
        "\tHungary -- Croatia\n" +
        "\tHungary -- Serbia\n" +
        "\tSerbia -- Croatia\n" +
        "\tSerbia -- BosniaAndHerzegovina\n" +
        "\tSerbia -- Montenegro\n" +
        "\tSerbia -- Albania\n" +
        "\tSerbia -- Macedonia\n" +
        "\tMacedonia -- Albania\n" +
        "\tMacedonia -- Greece\n" +
        "\tGreece -- Albania\n" +
        "\tAlbania -- Montenegro\n" +
        "\tMontenegro -- BosniaAndHerzegovina\n" +
        "\tMontenegro -- Croatia\n" +
        "\tBosniaAndHerzegovina -- Croatia\n" +
        "\tCroatia -- Slovenia\n" +
        "\tSlovenia -- Italy\n" +
        "\tItaly -- Switzerland\n" +
        "\tItaly -- France\n" +
        "\tSwitzerland -- France\n" +
        "\tFrance -- Spain\n" +
        "\tSpain -- Portugal"

private const val gS = "Russia -- Norway\n" +
        "\tRussia -- Finland\n" +
        "\tRussia -- Estonia\n" +
        "\tRussia -- Latvia\n" +
        "\tRussia -- Belarus\n" +
        "\tRussia -- Lithuania\n" +
        "\tRussia -- Poland\n" +
        "\tRussia -- Ukraine\n" +
        "\tRussia -- Georgia\n" +
        "\tNorway -- Sweden\n" +
        "\tNorway -- Finland\n" +
        "\tFinland -- Sweden\n" +
        "\tSweden -- Denmark\n" +
        "\tEstonia -- Latvia\n" +
        "\tLatvia -- Lithuania\n" +
        "\tLatvia -- Belarus\n" +
        "\tLatvia -- Poland\n" +
        "\tBelarus -- Lithuania\n" +
        "\tBelarus -- Poland\n" +
        "\tBelarus -- Ukraine\n" +
        "\tLithuania -- Poland\n" +
        "\tUkraine -- Poland\n" +
        "\tUkraine -- Slovakia\n" +
        "\tUkraine -- Hungary\n" +
        "\tUkraine -- Romania\n" +
        "\tUkraine -- Moldova\n" +
        "\tGeorgia -- Armenia\n" +
        "\tGeorgia -- Turkey\n" +
        "\tArmenia -- Turkey\n" +
        "\tMoldova -- Romania\n" +
        "\tPoland -- Germany\n" +
        "\tPoland -- Czech\n" +
        "\tPoland -- Slovakia\n" +
        "\tDenmark -- Germany\n" +
        "\tGermany -- Netherlands\n" +
        "\tGermany -- Belgium\n" +
        "\tGermany -- Luxembourg\n" +
        "\tGermany -- France\n" +
        "\tGermany -- Switzerland\n" +
        "\tGermany -- Austria\n" +
        "\tGermany -- Czech\n" +
        "\tCzech -- Austria\n" +
        "\tCzech -- Slovakia\n" +
        "\tSlovakia -- Austria\n" +
        "\tSlovakia -- Hungary\n" +
        "\tRomania -- Hungary\n" +
        "\tRomania -- Serbia\n" +
        "\tRomania -- Bulgaria\n" +
        "\tBulgaria -- Serbia\n" +
        "\tBulgaria -- Macedonia\n" +
        "\tBulgaria -- Greece\n" +
        "\tBulgaria -- Turkey\n" +
        "\tTurkey -- Greece\n" +
        "\tNetherlands -- Belgium\n" +
        "\tBelgium -- France\n" +
        "\tBelgium -- Luxembourg\n" +
        "\tLuxembourg -- France\n" +
        "\tAustria -- Switzerland\n" +
        "\tAustria -- Italy\n" +
        "\tAustria -- Slovenia\n" +
        "\tAustria -- Hungary\n" +
        "\tHungary -- Slovenia\n" +
        "\tHungary -- Croatia\n" +
        "\tHungary -- Serbia\n" +
        "\tSerbia -- Croatia\n" +
        "\tSerbia -- BosniaAndHerzegovina\n" +
        "\tSerbia -- Montenegro\n" +
        "\tSerbia -- Albania\n" +
        "\tSerbia -- Macedonia\n" +
        "\tMacedonia -- Albania\n" +
        "\tMacedonia -- Greece\n" +
        "\tGreece -- Albania\n" +
        "\tAlbania -- Montenegro\n" +
        "\tMontenegro -- BosniaAndHerzegovina\n" +
        "\tMontenegro -- Croatia\n" +
        "\tBosniaAndHerzegovina -- Croatia\n" +
        "\tCroatia -- Slovenia\n" +
        "\tSlovenia -- Italy\n" +
        "\tItaly -- Switzerland\n" +
        "\tItaly -- France\n" +
        "\tSwitzerland -- France\n" +
        "\tFrance -- Spain\n" +
        "\tSpain -- Portugal\n" +
        "\tUnitedKingdom -- Ireland\n" +
        "\tIceland\n"