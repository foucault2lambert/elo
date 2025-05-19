package data

class Player(val name: String, val elo: Long) {
    override fun toString(): String {
        return "Player(name='$name', elo=$elo)"
    }
}
