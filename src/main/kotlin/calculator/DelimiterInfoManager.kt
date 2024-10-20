package calculator

private val DEFAULT_DELIMITERS = listOf(",", ":")
private val DELIMITERS_CONDITIONS = listOf("//", "\\n")

class DelimiterInfoManager {
    fun create(input: String): DelimiterInfo {
        val customDelimiter = getCustomDelimiter(input)
        val delimiters = createDelimiters(customDelimiter)
        return DelimiterInfo(
            delimiters = delimiters,
            customDelimiterPrefixLast = DELIMITERS_CONDITIONS[1],
        )
    }

    // 커스텀 구분자를 식별한다.
    private fun String.isContainCustomDelimiter(): Boolean {
        var cnt = 0
        DELIMITERS_CONDITIONS.forEach { dc ->
            if (dc in this) cnt++
        }
        return cnt != DELIMITERS_CONDITIONS.size
    }

    // 커스텀 구분자를 판별하고 만약 있다면 반환, 없다면 null을 반환한다.
    private fun getCustomDelimiter(input: String): String? {
        if (input.isContainCustomDelimiter()) {
            return null
        }
        val customDelimiter = input.split(*DELIMITERS_CONDITIONS.toTypedArray())
        if (customDelimiter[1].isEmpty()) {
            throw IllegalArgumentException()
        }
        return customDelimiter[1]
    }

    // 최종적으로 사용할 구분자 리스트를 만든다.
    private fun createDelimiters(customDelimiter: String?): List<String> {
        if (customDelimiter == null) {
            return DEFAULT_DELIMITERS
        }
        val mutableDefaultDelimiters = DEFAULT_DELIMITERS.toMutableList()
        mutableDefaultDelimiters.add(customDelimiter)
        return mutableDefaultDelimiters
    }
}
