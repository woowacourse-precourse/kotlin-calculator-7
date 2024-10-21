package calculator

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    // TODO: 프로그램 구현
}

fun add(input: String?): Int {
    if (input.isNullOrEmpty()) return 0 // 입력이 빈 문자열일 경우 0 반환

    // 쉼표 또는 콜론을 구분자로 숫자를 분리
    val delimiters = "[,:]".toRegex()
    return input.split(delimiters)
        .map { it.toInt() } // 각 숫자를 Int로 변환
        .sum() // 숫자들의 합을 반환
}
