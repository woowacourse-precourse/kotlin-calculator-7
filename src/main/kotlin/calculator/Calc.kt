package calculator

class Calc {
    private val add = Add()
    private val user = User()

    init {
        UserView.printStart()
    }

    fun addition() {
        val userNumbers = user.extractedNumbers()
        add.addNum(userNumbers)
    }
}