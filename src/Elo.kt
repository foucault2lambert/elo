import kotlin.math.pow

class Elo {
    private var elo1: Int
    private var elo2: Int
    private var resultEloP1: Int
    private var resultEloP2: Int

    constructor(p1: Int, p2: Int) {
        elo1 = p1
        elo2 = p2
        resultEloP1 = 0
        resultEloP2 = 0
    }
    fun  calculElo1() : Int{
        this.resultEloP1 = 1 - (2.toDouble().pow(elo1/100).toInt()) / (2.toDouble().pow(elo1/100).toInt()+2.toDouble().pow(elo2/100).toInt())
        return resultEloP1
    }
    fun  calculElo2() : Int{
        this.resultEloP2 = 1 - (2.toDouble().pow(elo2/100).toInt()) / (2.toDouble().pow(elo1/100).toInt()+2.toDouble().pow(elo2/100).toInt())
        return resultEloP2
    }
    fun getresultEloP1(): Int {
        return resultEloP1
    }
    fun getresultEloP2(): Int {
        return resultEloP2
    }
}
