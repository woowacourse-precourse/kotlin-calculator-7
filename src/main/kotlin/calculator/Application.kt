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
    print("결과 : $sum")
}

fun SplitChar(char: String?): List<Int>? {
    if (char == null) return null

    var modifiedChar = char
    val newLine = modifiedChar.indexOf('n')

    if (modifiedChar.startsWith("//")) {
        var newSeparator = modifiedChar.substring(2,3)
        val separators: String
        separators = newSeparator
        if(separators.toIntOrNull() == null){
            modifiedChar = modifiedChar.drop(newLine+2)
            var splitedChar = modifiedChar.split(separators)
            if(splitedChar.contains("")){
                throw IllegalArgumentException("String must not contain whitespace.")
            } else{
                return splitedChar.mapNotNull { it.toIntOrNull() }
            }
        } else{
            throw IllegalArgumentException("Separtator must not be Integer.")
        }
    } else {
        if(modifiedChar.startsWith(',') or modifiedChar.startsWith(":")){
            throw IllegalArgumentException("String must start with Integer.")
        } else{
            val separators = mutableListOf<Char>()
            separators.add(',')
            separators.add(':')
            var splitedChar = modifiedChar.split(*separators.toCharArray())
            if(splitedChar.contains("")){
                throw IllegalArgumentException("String must not contain whitespace.")
            } else{
                return splitedChar.mapNotNull { it.toIntOrNull() }
            }
        }
    }
}