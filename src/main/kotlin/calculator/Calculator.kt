package calculator

class Calculator {
    fun run(parsingList: List<Long>) {
        val result = add(parsingList)
        print(RESULT_MESSAGE + result)
    }

    private fun add(parsingList: List<Long>): Long {
        var sum = 0L
        for (n in parsingList) {
            sum += n
            if (sum.toString().length > MAX_NUMBER_LENGTH) throw IllegalArgumentException()
        }
        return sum
    }
}

private const val MAX_NUMBER_LENGTH = 15
private const val RESULT_MESSAGE = "결과 : "