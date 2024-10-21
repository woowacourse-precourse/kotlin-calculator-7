package calculator

class AddCalculator {
    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) {
            return 0
        }
        val delimiter = getDelimiter(input)
        val numbers = splitNumbers(input, delimiter)
        return numbers.sum()
    }

    fun getDelimiter(input: String): String {
        if (input.startsWith("//")) {
            if (input.contains("\n")) {
                return input.substring(2, input.indexOf("\n"))
            }else{
                throw IllegalArgumentException("커스텀 구분자 입력이 잘못되었습니다.")
            }
        }else{
            return ",|:"
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
        return if (number.toInt()< 0) {
            throw IllegalArgumentException("음수는 입력할 수 없습니다.")
        } else {
            number.toInt()
        }
    }
}