package data

import java.util.Date

class Matche(var players: List<Player>, var date: Date) {
    override fun toString(): String {
        return "Matche(players=$players, date=$date)"
    }
}