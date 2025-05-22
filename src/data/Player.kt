package data

class Player(val name: String, val elo: Long) {
    override fun toString(): String {
        return "Player(name='$name', elo=$elo)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Player

        if (elo != other.elo) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = elo.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }

    operator fun compareTo(other: Player) = elo.compareTo(other.elo)
}
