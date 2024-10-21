package calculator

class AddCalculator {
    private val validate = ExceptionManager()
    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) {
            return 0
        }
        validate.Input(input)
        val delimiter = getDelimiter(input)
        val numbers = splitNumbers(input, delimiter)
        return numbers.sum()
    }

    private fun getDelimiter(input: String): String {
        if (input.startsWith("//")) {
            if (input.contains("\\n")) {
                val customDelimiter = input.substring(2, input.indexOf("\\n"))
                return customDelimiter.toCharArray().joinToString("|") { Regex.escape(it.toString()) }
            } else {
                throw IllegalArgumentException("커스텀 구분자 입력이 잘못되었습니다.")
            }
        } else if (input.contains(",") || input.contains(":")){
            return ",|:"
        }else {
            throw IllegalArgumentException("구분자 입력이 잘못되었습니다.")
        }
    }

    private fun splitNumbers(input: String, delimiter: String): List<Int> {
        val numbers = if (input.startsWith("//")) {
            input.substringAfter("\\n")
        } else {
            input
        }
        return numbers.split(Regex(delimiter)).map { toPositive(it) }
    }

    private fun toPositive(number: String): Int {
        if (number == "")
            return 0
        return if (number.toInt()< 0) {
            throw IllegalArgumentException("음수는 입력할 수 없습니다.")
        } else {
            number.toInt()
        }
    }
}