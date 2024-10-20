package calculator

fun main() {
    var char = readLine()
    var splitedChar = SplitChar(char)
    var sum = splitedChar?.sum()
}

fun SplitChar(char: String?): List<Int>? {
    var splitedChar = char?.split(',','"')
    var splitedCharToInt = splitedChar?.map { it.toInt() }
    return splitedCharToInt
}
