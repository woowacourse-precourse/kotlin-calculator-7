package calculator

fun main() {
    // TODO: 프로그램 구현
}

fun calculate(string: String): Int {
    if (string == "") {
        return 0
    }
    
    val strings = string.split(",")
    val ints = strings.map { it.toInt() }

    return ints.sum()
}