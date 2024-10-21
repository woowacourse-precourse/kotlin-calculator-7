package calculator

class Separator {
    private val separates: MutableList<Char> = mutableListOf(',', ':')
    private val customSeparates = Pair("//", "\n")
    private var startIndex = 0
    private var endIndex = 0
    private val result: MutableList<Int> = mutableListOf(0)

    // 커스텀 구분자가 있는 경우 separates 변수에 추가하는 함수
    private fun getCustomSeparate(input: String) {
        if (!input.startsWith(customSeparates.first)) return

        startIndex = customSeparates.first.length
        endIndex = input.indexOf(customSeparates.second)
        require(endIndex != 1) {"커스텀 구분자를 이용하려면 //, \n 사이에 작성하세요."}

        separates.addAll(input.substring(startIndex, endIndex).toList())
    }

    // 구분자를 통해 구분하는 함수
    fun run(input: String): List<Int> {
        if (input.isBlank()) return listOf(0)

        if (input.startsWith(customSeparates.first)) {
            getCustomSeparate(input)
            if (endIndex+customSeparates.second.length == input.length) return listOf(0)
        }

        input.split(*separates.toCharArray()).forEach { item ->
            item.toIntOrNull()?.let {
                result.add(it)
            } ?: run {
                throw IllegalArgumentException("구분된 ${item}은 숫자가 아닙니다.")
            }
        }

        return result
    }
}