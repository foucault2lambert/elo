import kotlin.math.pow

class Elo {
    private var eloJoueur: Int
    private var eloOpposant: Int
    private var victoire : Boolean


    constructor(eloJoueur: Int, eloOpposant: Int, victoiree: Boolean) {
        this.eloJoueur = eloJoueur
        this.eloOpposant = eloOpposant
        this.victoire  = victoiree

    }
    fun getEloJoueur(): Int {
        return eloJoueur
    }
    fun getEloOpposant(): Int {
        return eloOpposant
    }
    fun  calculEloJoueur() : Int{
        if(!this.victoire){
            this.eloJoueur = 1 - (2.toDouble().pow(eloJoueur/100).toInt()) / (2.toDouble().pow(eloJoueur/100).toInt()+2.toDouble().pow(eloOpposant/100).toInt())
            println("testcalculeloJoueurDefaite")
        }
        else{
            this.eloJoueur = 1 + (2.toDouble().pow(eloJoueur/100).toInt()) / (2.toDouble().pow(eloJoueur/100).toInt()+2.toDouble().pow(eloOpposant/100).toInt())
            println("testcalculeloJoueurVictoire")
        }
        return this.eloJoueur
    }
    fun  calculEloOpposant() : Int{
        if(this.victoire){
            this.eloOpposant = 1 - (2.toDouble().pow(eloJoueur/100).toInt()) / (2.toDouble().pow(eloJoueur/100).toInt()+2.toDouble().pow(eloOpposant/100).toInt())
        }
        else{
            this.eloOpposant = 1 + (2.toDouble().pow(eloJoueur/100).toInt()) / (2.toDouble().pow(eloJoueur/100).toInt()+2.toDouble().pow(eloOpposant/100).toInt())
        }
        return this.eloOpposant
    }

}

