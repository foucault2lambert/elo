package data

import org.junit.jupiter.api.Assertions.*

class DatabaseTest {
    val database = Database("src/data/database")

    @org.junit.jupiter.api.Test
    fun getPlayerByName() {
        val foucault = database.getPlayerByName("Foucault")
        val simon = database.getPlayerByName("Simon")
        val errorName = database.getPlayerByName("Asassino capuccino")

        // sujet à changements donc à vérifier que c'est en accord avec la base de donnée.
        assertNotNull(foucault)
        assertEquals("Foucault",foucault?.name)
        assertEquals(400, foucault?.elo)

        assertNotNull(simon)
        assertEquals("Simon",simon?.name)
        assertEquals(400, simon?.elo)

        assertNull(errorName)
        assertNull(errorName?.elo)
        assertNull(errorName?.elo)

        database.close()
    }

}