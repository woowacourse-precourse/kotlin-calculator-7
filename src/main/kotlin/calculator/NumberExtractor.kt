package calculator

class NumberExtractor {
    private var separators: MutableList<String> = mutableListOf(COMMA, COLON)

    fun addExtractor(separator: String) {
        if (separator.length != 1) {
            throw IllegalArgumentException("구분자의 길이가 1을 초과했습니다.")
        }

        separators.add(separator)
    }

    companion object {
        const val COMMA = ","
        const val COLON = ":"
    }
}
