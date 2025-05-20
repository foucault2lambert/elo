//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val elodaniel = Elo(100, 200,true)
    println("elo daniel avant match : ${elodaniel.calculEloJoueur()}")
    println("elo opp" +
            "daniel avant match : ${elodaniel.calculEloOpposant()}")
    println("daneiel a gagné")
    elodaniel.calculEloJoueur()
    elodaniel.calculEloOpposant()
    println("elo daniel apres match: ${elodaniel.calculEloOpposant()}")
    println("elo opposant de daniel apres match: ${elodaniel.calculEloOpposant()}")
}