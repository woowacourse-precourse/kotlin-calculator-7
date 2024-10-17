package calculator

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")

    val input = readLine()
    var answer = 0
    val numberList = input?.split(Regex("\\D+"))
        ?.filter { it.isNotEmpty() }
        ?.map { it.toInt() }

    println("추출된 숫자 리스트: ${numberList}")
}
