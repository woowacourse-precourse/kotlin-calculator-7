package calculator

class Calculator {
    fun calculateString(inputString: String) {
        // 1. 커스텀 구분자가 있다면 커스텀 구분자를 추가하고, 각 문자를 분리한다.
        val splitList = splitStringToList(inputString)

        // 2. 각 숫자들의 총 합을 구한다.
        val sum = getSum(splitList)

        // 3. 결과를 출력한다.
        printResult(sum)
    }

    private fun splitStringToList(inputString: String): List<String> {
        val checkString = validator.validateString(inputString)
        val delimiter = validator.getDelimiter(inputString)

        val splitList = checkString.split(delimiter.toRegex())

        return splitList
    }

    private fun getSum(splitList: List<String>): Int =
        splitList.sumOf {
            it.toInt()
        }

    private fun printResult(sum: Int) {
        println("결과 : $sum")
    }

    companion object {
        private val validator = Validator()
    }
}
