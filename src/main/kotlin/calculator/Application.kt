package calculator

fun main() {
    println("덧셈할 문자열을 입력해주세요.")
    var char = readLine()
    var splitedChar = SplitChar(char)
    var sum = splitedChar?.sum()
    print("결과 : $sum")
}

fun SplitChar(char: String?): List<Int>? {
    if (char == null) return null

    var modifiedChar = char
    val separators = mutableListOf(',', ':')

    if (modifiedChar.startsWith("/")) {
        modifiedChar.getOrNull(2)?.let { separators.add(it) }
        modifiedChar = modifiedChar.drop(5)
    }

    val splitedChar = modifiedChar.split(*separators.toCharArray())
    return splitedChar.mapNotNull { it.toIntOrNull() }
}