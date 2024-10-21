package calculator

class Separator {
    val separates: MutableList<Char> = mutableListOf(',', ':')
    val customSeparates = Pair("//", "\n")

    private fun getCustomSeparate(input: String) {
        if (!input.startsWith(customSeparates.first)) return

        val startIndex = customSeparates.first.length
        val endIndex = input.indexOf(customSeparates.second)
        require(endIndex != 1) {"커스텀 구분자를 이용하려면 //, \n 사이에 작성하세요."}

        separates.addAll(input.substring(startIndex, endIndex).toList())
    }

    fun run(input: String) {
        getCustomSeparate(input)
    }
}