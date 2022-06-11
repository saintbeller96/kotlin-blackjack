package blackjack.domain

interface Participant {
    val name: String
    val hand: Hand
    val state: State

    fun point(): Point = hand.calculate()
    fun playable(): Boolean = state is Hittable
    fun saidHit(): Boolean
    fun receive(card: Card)
    fun open(): Hand = hand
    fun match(dealer: Dealer): Match
}

enum class Match {
    WIN, LOSE, DRAW
}
