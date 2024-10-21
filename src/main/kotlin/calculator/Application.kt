package calculator

fun main() {
    // TODO: 프로그램 구현
}

fun calculate(string: String): Int {
    if (string == "") return 0
    
    val strings = splitForCalculate(string)
    val numbers = strings.map { it.toInt() }

    return numbers.sum()
}

fun splitForCalculate(string: String): List<String> {
    if (Regex("//.\\n(.+)").matches(string)) {
        return string.substring(4).split(string[2])
    }

    return string.split(",", ":")
}