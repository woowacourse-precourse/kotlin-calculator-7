package calculator

class Add {
    fun addNum(userString: List<Int>) {
        val result = userString.sum()
        UserView.printResult(result)
    }
}