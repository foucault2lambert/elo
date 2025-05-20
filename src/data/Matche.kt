package data

import java.sql.ResultSet
import java.util.Date

class Match(val players: List<Player>, val date: Date, val diffs: List<Int>) {
    constructor(result: ResultSet) : this(
        players = listOf(
            Player(
                result.getString("playerA"),
                result.getInt("playerA_elo").toLong()
            ),
            Player(
                result.getString("playerB"),
                result.getInt("playerB_elo").toLong()
            ),
        ),
        date = Date(),
        diffs = listOf(
            result.getInt("balance_playerA"), result.getInt("balance_playerB")
        )
    )

    fun getWinner(): Player = if (diffs[0] > 0) players[0] else  players[1]

    override fun toString(): String {
        return "Match(players=$players, date=$date)"
    }
}
