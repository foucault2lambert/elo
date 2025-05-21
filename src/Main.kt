//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val elodaniel = Match(10, 200,true)

    println("elo daniel avant match : ${elodaniel.getEloJoueur()}")
    println("elo opp" + "daniel avant match : ${elodaniel.getEloOpposant()}")
    println("daneiel a gagné")
    elodaniel.calculEloJoueur()
    elodaniel.calculEloOpposant()
    println("elo daniel apres match: ${elodaniel.calculEloJoueur()}")
    println("elo opposant de daniel apres match: ${elodaniel.calculEloOpposant()}")
}