import data.Database

fun main() {

    val database = Database("src/data/database")

    println(database.getPlayerByName("Foucault"))

    database.close()
    val elodaniel = Match(database.getPlayerByName("Foucault"), database.getPlayerByName("Simon"),true)
    println("elo daniel avant match : ${elodaniel.getEloJoueur()}")
    println("elo opp" + "daniel avant match : ${elodaniel.getEloOpposant()}")
    println("daneiel a gagné")
    elodaniel.calculEloJoueur()
    elodaniel.calculEloOpposant()
    println("elo daniel apres match: ${elodaniel.calculEloJoueur()}")
    println("elo opposant de daniel apres match: ${elodaniel.calculEloOpposant()}")
    println("la diff d'elo est : ${elodaniel.getDeltaElo()}")
}