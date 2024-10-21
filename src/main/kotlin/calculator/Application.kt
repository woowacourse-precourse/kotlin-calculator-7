package calculator

fun main() {
    // TODO: 프로그램 구현
    println("덧셈할 문자열을 입력해 주세요.")
    val input = readLine() ?: throw IllegalArgumentException("입력 값이 없습니다.")

    try {
        val result = add(input)
        println("결과 : ${result}")
    } catch (e: IllegalArgumentException) {
        println("오류: ${e.message}")
    }
}

fun add(input: String): Int {
    if (input.isEmpty()) {
        return 0
    }

    val specChar = mutableListOf(",", ":")
    var onlyNum = input

    // 커스텀 구분자 확인
    if (input.startsWith("//")) {
        val specCharEnd = input.indexOf("\n")

        if (specCharEnd == -1) {
            throw IllegalArgumentException("잘못된 형식입니다.")
        }
        val customSpecChar = input.substring(2, specCharEnd)
        specChar.add(customSpecChar)
        onlyNum = input.substring(specCharEnd + 1)
        //println(customSpecChar)
    }

    // 문자열에서 숫자를 분리
    val separation = specChar.joinToString(separator = "|") {Regex.escape(it)}.toRegex()
    val numbers = onlyNum.split(separation)

    // 숫자 합산 && 유효성 검사
    val sum = numbers.map {
        val num = it.toIntOrNull() ?: throw IllegalArgumentException("잘못된 숫자 형식입니다.: ${it}")
        if (num < 0) throw IllegalArgumentException("양수만 허용됩니다: ${num}")
        num
    }.sum()

    return sum
}
