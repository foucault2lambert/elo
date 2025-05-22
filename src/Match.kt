import data.Player
import kotlin.math.pow

class Match {
    private var eloJoueur: Long
    private var eloOpposant: Long
    private var victoire: Boolean
    private var kFacteur: Int
    private  var newEloOpposant: Long
    private  var newEloJoueur: Long
    private  var deltaElo: Long = 0


    constructor(joueur1: Player?, joueur2 : Player?, victoireDuPremierJoueur: Boolean) {
        this.eloJoueur = joueur1!!.elo
        this.eloOpposant = joueur2!!.elo
        this.victoire = victoireDuPremierJoueur
        this.kFacteur = 40
        this.newEloOpposant = eloOpposant
        this.newEloJoueur = eloOpposant
    }
    fun getDeltaElo(): Long {
        this.deltaElo = this.newEloOpposant - this.eloOpposant
        return this.deltaElo
    }

    fun setkFacteur(facteur: Int) {
        this.kFacteur = facteur
    }

    fun getEloJoueur(): Long {
        return eloJoueur
    }

    fun getEloOpposant(): Long {
        return eloOpposant
    }

    fun calculEloJoueur(): Long {//calcul l'elo du "joueur" apres match
        val expectedScore = 1 / (1 + 10.0.pow((this.eloOpposant - this.eloJoueur) / 400.0))
        var result = 0
        if (victoire){
            result = 1
        }else{
            result = 0
        }
        this.newEloJoueur = (this.eloJoueur + kFacteur * (result - expectedScore)).toLong()
        //println("expectedScoreJ: $expectedScore")
        return this.newEloJoueur
    }
    fun calculEloOpposant(): Long {
        val expectedScore = 1 / (1 + 10.0.pow((this.eloOpposant - this.eloJoueur) / 400.0))
        var result = 0
        if (victoire){
            result = 0
        }else{
            result = 1
        }
        this.newEloOpposant = (this.eloOpposant + kFacteur * (result - expectedScore)).toLong()
        //println("expectedScoreJ: $expectedScore")
        return this.newEloOpposant

        }
}
