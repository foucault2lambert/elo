package data

import java.sql.DriverManager
import java.sql.ResultSet

class Database(dbName: String) {
    val connection = DriverManager.getConnection("jdbc:sqlite:$dbName.db")

    private fun select(query:String): ResultSet {
        try {
            val stmt = connection.createStatement()
            return stmt.executeQuery(query)
        } finally {

        }
    }

    fun getPlayerByName(playerName: String): Player? {
        var res: ResultSet = select("SELECT * FROM PLAYER WHERE name='$playerName' LIMIT 1")
        return Player(
            res.getString("name"),
            res.getInt("elo").toLong()
        )
    }

    fun close() =  connection.close()

}