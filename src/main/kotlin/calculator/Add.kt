package calculator

class Add {
    fun addNum(userNumbers: List<Int>) {
        val result = userNumbers.sum()
        UserView.printResult(result)
    }
}