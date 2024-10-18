package calculator

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")

    val input = readLine()
    var answer = 0
    val numberList = input?.split(Regex("\\D+"))
        ?.filter { it.isNotEmpty() }
        ?.map { it.toInt() }

    answer = numberList?.sum() ?: 0

    println("결과 : ${answer}")
}
