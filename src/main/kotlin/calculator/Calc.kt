package calculator

class Calc {
    private val user = User()

    init {
        UserView.printStart()
    }

    fun add() {
        val userNumbers = user.getNumbers()
        val result = userNumbers.sum()
        UserView.printResult(result)
    }
}