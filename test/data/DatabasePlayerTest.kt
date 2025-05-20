package data

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DatabasePlayerTest {
    val playerTest = Player("Tralalero Tralaler", 3400)
    @Test
    fun getName() {
        assertEquals("Tralalero Tralaler", playerTest.name)
    }

    @Test
    fun getElo(){
        assertEquals(3400, playerTest.elo)
    }

}