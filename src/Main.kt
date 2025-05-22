import data.Database

fun main() {

    val database = Database("src/data/database")


    val MatchFoucaultSimon = Match(database.getPlayerByName("Foucault"), database.getPlayerByName("Simon"),false)
    println("elo Foucault avant match : ${MatchFoucaultSimon.getEloJoueur()}")
    println("elo opp" + "Foucault avant match : ${MatchFoucaultSimon.getEloOpposant()}")
    println("Foucault a perdu")
    MatchFoucaultSimon.calculEloJoueur()
    MatchFoucaultSimon.calculEloOpposant()
    println("elo Foucaut apres match: ${MatchFoucaultSimon.calculEloJoueur()}")
    println("elo Simon apres match: ${MatchFoucaultSimon.calculEloOpposant()}")
    println("la diff d'elo est : ${MatchFoucaultSimon.getDeltaElo()}")
    database.close()
}
