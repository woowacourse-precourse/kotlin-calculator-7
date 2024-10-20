package calculator

private const val INPUT_NOTICE_TEXT = "덧셈할 문자열을 입력해 주세요."
private const val RESULT_TEXT = "결과 : "

class StringPlusCalculator {
    private val delimiterManager: DelimiterInfoManager = DelimiterInfoManager()

    fun execute(readLine: () -> String) {
        println(INPUT_NOTICE_TEXT)
        val input = readLine().isNotEmptyOrThrow()
        val result = calculate(input)
        println(RESULT_TEXT + result)
    }

    private fun calculate(input: String): Int {
        val delimiterInfo = delimiterManager.create(input)
        val splitInput = splitByDelimiters(input, delimiterInfo)
        val sumOfSplitInput =
            splitInput
                .toPositiveIntList()
                .sum()
        return sumOfSplitInput
    }

    // 구분자를 기준으로 문자열을 나눈다.
    private fun splitByDelimiters(
        input: String,
        delimiterInfo: DelimiterInfo,
    ): List<String> {
        val removedPrefixInput =
            input
                .split(delimiterInfo.customDelimiterPrefixLast)
                .last()
        return removedPrefixInput.split(*delimiterInfo.delimiters.toTypedArray())
    }
}
