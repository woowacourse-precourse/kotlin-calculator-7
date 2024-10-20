package calculator

import camp.nextstep.edu.missionutils.Console

fun main(args: Array<String>) {
    // 사용자로부터 입력값 받기
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine()

    // 예외 처리와 결과 출력
    try {
        val result = add(input)
        println("결과 : $result")
    } catch (e: IllegalArgumentException) {
        println("잘못된 입력입니다: ${e.message}")
    }
}

// 구분자를 구분하고, 숫자들을 모아서 더한 값을 출력하는 함수
fun add(input: String): Int {
    // 빈 문자열 처리
    if (input.isEmpty()) return 0

    // 입력이 //로 시작하면 커스텀 구분자 처리, 그렇지 않으면 기본 구분자 사용
    val (delimiters, numbers) = if (input.startsWith("//")) {
        findCustomDelimiter(input) ?: throw IllegalArgumentException("잘못된 구분자 형식입니다.")
    } else {
        Pair("[,:]".toRegex(), input)
    }

    // 커스텀 구분자와 기본 구분자 혼합 사용 시 예외 처리
    if (input.startsWith("//") && (numbers.contains(",") || numbers.contains(":"))) {
        throw IllegalArgumentException("커스텀 구분자와 기본 구분자를 혼합하여 사용할 수 없습니다.")
    }

    // 연속된 구분자가 있는지 확인하는 정규 표현식
    val consecutiveDelimiterPattern = "${delimiters.pattern}{2,}".toRegex()
    if (consecutiveDelimiterPattern.containsMatchIn(numbers)) {
        throw IllegalArgumentException("구분자가 연속으로 나타날 수 없습니다.")
    }

    // 구분자를 사용하여 숫자를 분리하고 유효하지 않은 문자가 있는지 확인 및 음수 확인
    val parsedNumbers = numbers.split(delimiters).map {
        val trimmed = it.trim()
        // 숫자 이외의 문자가 있는지 확인
        val num = trimmed.toIntOrNull() ?: throw IllegalArgumentException("숫자 이외의 문자가 포함되었습니다: $trimmed")

        // 음수가 포함된 경우 예외 처리
        if (num < 0) {
            throw IllegalArgumentException("음수는 허용되지 않습니다: $num")
        }
        num
    }

    return parsedNumbers.sum() // 숫자 합산
}

// 커스텀 구분자 찾는 함수
fun findCustomDelimiter(input: String): Pair<Regex, String>? {
    // 입력이 //로 시작하지만 \n이 포함되지 않은 경우 예외 처리
    if (!input.contains("\\n")) {
        throw IllegalArgumentException("입력값은 //로 시작하고 \\n으로 끝나야 합니다.")
    }

    // 유효한 커스텀 구분자를 찾기 위한 정규 표현식
    val regex = Regex("//([^0-9])\\\\n(.*)")
    val matchResult = regex.find(input)

    // 커스텀 구분자 형식이 올바르지 않으면 예외 처리
    return matchResult?.let {
        val customDelimiter = it.groupValues[1]
        if (customDelimiter.isEmpty()) {
            throw IllegalArgumentException("유효한 커스텀 구분자가 지정되지 않았습니다.")
        }
        val numbers = it.groupValues[2] // 숫자 부분
        Pair(Regex(Regex.escape(customDelimiter)), numbers)
    }
}
