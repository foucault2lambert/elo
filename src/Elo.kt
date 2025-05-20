import kotlin.math.pow

class Elo {
    private var eloJoueur: Int
    private var eloOpposant: Int
    private var victoire: Boolean
    private var kFacteur: Int
    private  var newEloOpposant: Int
    private  var newEloJoueur: Int


    constructor(eloJoueur: Int, eloOpposant: Int, victoiree: Boolean) {
        this.eloJoueur = eloJoueur
        this.eloOpposant = eloOpposant
        this.victoire = victoiree
        this.kFacteur = 40
        this.newEloOpposant = eloOpposant
        this.newEloJoueur = eloOpposant
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
        var result = 0
        if (victoire){
            result = 1
        }else{
            result = 0
        }
        this.newEloJoueur = (this.eloJoueur + kFacteur * (result - expectedScore)).toInt()
        return this.newEloJoueur
    }
    fun calculEloOpposant(): Int {
        val expectedScore = 1 / (1 + 10.0.pow((this.eloOpposant - this.eloJoueur) / 400.0))
        var result = 0
        if (victoire){
            result = 1
        }else{
            result = 0
        }
        this.newEloOpposant = (this.eloOpposant + kFacteur * (result - expectedScore)).toInt()
        return this.newEloOpposant

        }
}
