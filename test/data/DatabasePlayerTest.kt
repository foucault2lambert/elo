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

    @Test
    fun operatorOverloading(){
        val player2 = Player("Magnus Carlsen", 2837)
        val player3 = playerTest

        assertTrue(player2 < playerTest)
        assertFalse(playerTest == player2)
        assertTrue(player3 == playerTest)
    }

}