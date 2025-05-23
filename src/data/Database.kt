package data

import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException

class Database(dbName: String) {
    private val connection = DriverManager.getConnection("jdbc:sqlite:$dbName.db")

    private fun select(query: String): ResultSet {
        try {
            val stmt = connection.createStatement()
            return stmt.executeQuery(query)
        } finally {
        }
    }

    fun getPlayerByName(playerName: String): Player? {
        val res: ResultSet = select("SELECT * FROM PLAYER WHERE name='$playerName' LIMIT 1")

        return try {
            Player(
                res.getString("name"),
                res.getInt("elo").toLong()
            )
        } catch (_: NullPointerException) {
            null
        }
    }

    fun getMatches(): List<Match> {
        val query: String = "SELECT GAMES.DATE,\n" +
                "       P1.name    AS playerA,\n" +
                "       P2.name    AS playerB,\n" +
                "       P1.elo     AS playerA_elo,\n" +
                "       P2.elo     AS playerB_elo,\n" +
                "       R1.balance AS balance_playerA,\n" +
                "       R2.balance AS balance_playerB\n" +
                "FROM GAMES\n" +
                "         JOIN\n" +
                "     RESULTS R1 ON GAMES.id = R1.id_game\n" +
                "         JOIN\n" +
                "     RESULTS R2 ON GAMES.id = R2.id_game AND R1.player < R2.player\n" +
                "         JOIN\n" +
                "     PLAYER P1 ON R1.player = P1.id\n" +
                "         JOIN\n" +
                "     PLAYER P2 ON R2.player = P2.id\n" +
                "ORDER BY GAMES.DATE"
        val res: ResultSet = select(query)

        val matchList = mutableListOf<Match>()

        while (res.next()) {
            matchList.add(Match(res))
        }
        return matchList
    }

    fun addMatch(match: Match): Boolean {
        var query = "INSERT INTO GAMES(DATE) VALUES(?)"

        // GAMES table
        var statement = connection.prepareStatement(query)
        statement.setString(1, match.date.toString())
        try {
            statement.executeUpdate()
        } catch (_: SQLException) {
            return false
        }

        (0..<match.players.size).forEach {
            // PLAYER table
            if (getPlayerByName(match.players[it].name) == null) { // new player
                query = "INSERT INTO PLAYER(name) VALUES (?)"

                statement = connection.prepareStatement(query)
                statement.setString(1, match.players[0].name)
            } else {
                query = "UPDATE PLAYER SET elo = ? WHERE name = ?"

                statement = connection.prepareStatement(query)
                statement.setInt(1, (match.players[it].elo + match.diffs[it]).toInt())
                statement.setString(2, match.players[it].name)
            }

            try {
                statement.executeUpdate()
            } catch (_: SQLException) {
                return false
            }

            // RESULTS table
            val gameId = select("SELECT GAMES.id FROM GAMES ORDER BY id DESC LIMIT 1").getInt("id")
            val playerId =
                select("SELECT PLAYER.id FROM PLAYER WHERE name='${match.players[it].name}' ORDER BY id DESC").getInt("id")

            query = "INSERT INTO RESULTS(ID_GAME, PLAYER, BALANCE) VALUES(?,?,?)"
            statement = connection.prepareStatement(query)
            statement.setInt(1, gameId)
            statement.setInt(2, playerId)
            statement.setInt(3, match.diffs[it])

            try {
                statement.executeUpdate()
            } catch (_: Exception) {
                return false
            }
        }
        return true
    }

    fun close() = connection.close()

}