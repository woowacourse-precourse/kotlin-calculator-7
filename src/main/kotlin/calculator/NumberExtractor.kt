package calculator

class NumberExtractor {
    private var separators: MutableList<String> = mutableListOf(COMMA, COLON)

    fun addSeparator(separator: String) {
        if (separator.length != 1) {
            throw IllegalArgumentException("구분자의 길이가 1을 초과했습니다.")
        }

        separators.add(separator)
    }

    fun extractNumbers(input: String): LongArray {
        inputValidator(input)

        var slice = mutableListOf(input)
        for (separator in separators) {
            val tmp = mutableListOf<String>()
            val iterator = slice.iterator()

            while (iterator.hasNext()) {
                tmp.addAll(iterator.next().split(separator))
            }
            slice = tmp
        }

        removeBlankStringList(slice)
        return convertStringListToLongArray(slice)
    }

    private fun inputValidator(input: String) {
        val validNumbers = getNumberList()

        for (char in input) {
            val charAsString = char.toString()
            if (!validNumbers.contains(charAsString) && !separators.contains(charAsString)) {
                throw IllegalArgumentException("잘못된 값이 입력되었습니다.")
            }
        }
    }

    companion object {
        const val COMMA = ","
        const val COLON = ":"

        private const val ZERO = "0"
        private const val ONE = "1"
        private const val TWO = "2"
        private const val THREE = "3"
        private const val FOUR = "4"
        private const val FIVE = "5"
        private const val SIX = "6"
        private const val SEVEN = "7"
        private const val EIGHT = "8"
        private const val NINE = "9"

        fun getNumberList(): List<String> {
            return listOf(ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE)
        }
    }
}
