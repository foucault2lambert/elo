import data.Database

fun main() {
    val database = Database("src/data/database")

    println(database.getPlayerByName("Foucault"))

    database.close()
}