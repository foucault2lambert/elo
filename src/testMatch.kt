import kotlin.math.pow
import data.Player
class testMatch {
    private var eloJoueur: Int
    private var eloOpposant: Int
    private var victoire: Boolean
    private var kFacteur: Int
    private  var newEloOpposant: Int
    private  var newEloJoueur: Int
    private  var deltaElo: Int = 0


    constructor(joueur1: Int, joueur2 : Int, victoireDuPremierJoueur: Boolean) {
        this.eloJoueur = joueur1
        this.eloOpposant = joueur2
        this.victoire = victoireDuPremierJoueur
        this.kFacteur = 40
        this.newEloOpposant = eloOpposant
        this.newEloJoueur = eloOpposant
        this.deltaElo = 0
    }
    fun getDeltaElo(): Int {
        this.deltaElo = this.newEloOpposant - this.eloOpposant
        return this.deltaElo
    }

    fun setkFacteur(facteur: Int) {
        this.kFacteur = facteur
    }

    fun getEloJoueur(): Int {
        return eloJoueur
    }

    fun getEloOpposant(): Int {
        return eloOpposant
    }

    fun calculEloJoueur(): Int {//calcul l'elo du "joueur" apres match
        val expectedScore = 1 / (1 + 10.0.pow((this.eloOpposant - this.eloJoueur) / 400.0))
        var result: Int
        if (victoire){
            result = 1
        }else{
            result = 0
        }
        this.newEloJoueur = (this.eloJoueur + kFacteur * (result - expectedScore)).toInt()
        println("expectedScoreJ: $expectedScore")
        return this.newEloJoueur
    }
    fun calculEloOpposant(): Int {
        val expectedScore = 1 / (1 + 10.0.pow((this.eloJoueur - this.eloOpposant) / 400.0))
        var result: Int
        if (victoire){
            result = 0
        }else{
            result = 1
        }
        this.newEloOpposant = (this.eloOpposant + kFacteur * (result - expectedScore)).toInt()
        println("expectedScoreJ: $expectedScore")
        return this.newEloOpposant

    }
}