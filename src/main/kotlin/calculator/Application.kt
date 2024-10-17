package calculator

fun main() {
    // TODO: 프로그램 구현
}

fun calculate(string: String): Int {
    if (string == "") {
        return 0
    }
    return string.toInt()
}