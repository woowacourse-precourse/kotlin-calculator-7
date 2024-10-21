package calculator

fun main() {
    println("덧셈할 문자열을 입력해주세요.")
    var char = readLine()
    if(char == ""){
        throw IllegalArgumentException("String value must be filled.")
    }
    var splitedChar = SplitChar(char)
    splitedChar?.forEach { ch->
        if(ch < 0){
            throw IllegalArgumentException("Int value must be positive number.")
        }
    }
    var sum = splitedChar?.sum()
    println("결과 : $sum")
}

fun SplitChar(char: String?): List<Int>? {
    if (char == null) return null

    var modifiedChar = char
    val separators = mutableListOf(',', ':')

    if (modifiedChar.startsWith("//")) {
        var newSeparator: Char = modifiedChar.get(2)
        separators.let { it.add(newSeparator) }
        if (newSeparator.toString().toIntOrNull() == null) {
            modifiedChar = modifiedChar.drop(5)
        } else {
            throw IllegalArgumentException("Separtator must not be Integer.")
        }
    }
    if (modifiedChar.startsWith(',') or modifiedChar.startsWith(":")) {
        throw IllegalArgumentException("String must start with Integer.")
    } else {
        var splitedChar = modifiedChar.split(*separators.toCharArray())
        if (splitedChar.contains("")) {
            throw IllegalArgumentException("String must not contain whitespace.")
        } else {
            return splitedChar.mapNotNull { it.toIntOrNull() }
        }
    }
}
