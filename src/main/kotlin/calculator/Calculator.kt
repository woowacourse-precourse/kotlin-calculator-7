package calculator

class Calculator {
    fun calculateString(inputString: String) {
        // 1. 커스텀 구분자가 있다면 커스텀 구분자를 추가하고, 각 문자를 분리한다.
        val splitList = splitString(inputString)

        // 2. 각 숫자들의 총 합을 구한다.
        val sum = getSum(splitList)

        // 3. 결과를 출력한다.
        printResult(sum)
    }

    fun splitString(inputString: String): List<String> {
        var delimiter = "[,:]"
        if (inputString[0] == '/') {
            val customDelimiter = validator.validateCustomDelimiter(inputString)
            delimiter =
                if (customDelimiter.isNotEmpty()) {
                    "$delimiter|$customDelimiter"
                } else {
                    delimiter
                }
        }

        val checkString = validator.validateString(inputString)
        val splitList = checkString.split(delimiter.toRegex())

        return splitList
    }

    fun getSum(splitList: List<String>): Int =
        splitList.sumOf {
            it.toInt()
        }

    fun printResult(sum: Int) {
        println("결과 : $sum")
    }

    companion object {
        private val validator = Validator()
    }
}
