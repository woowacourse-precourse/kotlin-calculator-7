package calculator

import camp.nextstep.edu.missionutils.Console

val separators = mutableListOf(",", ":")

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine()
    val splitNumbers = splitString(input)
    val result = splitNumbers.sum()
    println("결과 : $result")
}

fun splitString(input: String): List<Int> {
    if (input.trim().isEmpty()) {
        throw IllegalArgumentException("구분자와 양수로 구성된 문자열을 입력해 주세요.")
    }
    val processedInput = findCustomSeparator(input)
    return processedInput.split(*separators.toTypedArray())
        .filter { it.isNotBlank() }
        .map {
            convertToIntOrThrow(it.trim())
        }
}

fun findCustomSeparator(input: String): String {
    if (input.startsWith("//") && input.contains("\\n")) {
        val customSeparator = getCustomSeparator(input)
        separators.add(customSeparator)
        return Regex("""//.*\\n""").replace(input, "")
    }
    return input
}

fun getCustomSeparator(input: String): String {
    // "//"의 끝 위치와 "\n"의 시작 위치 찾기
    val startIndex = input.indexOf("//") + 2
    val endIndex = input.indexOf("\\n")

    val customSeparator = input.substring(startIndex, endIndex)

    // 커스텀 구분자가 숫자인 경우 예외 발생(빈 문자열인 경우도 숫자로 인식되어 예외 처리)
    if (customSeparator.isNotBlank() && customSeparator.trim().all { it.isDigit() }) {
        throw IllegalArgumentException("숫자는 커스텀 구분자로 사용할 수 없어요.")
    }

    // "//"와 "\n" 사이의 문자열을 추출하여 반환
    return customSeparator
}

fun convertToIntOrThrow(value: String): Int {
    // 문자열이 유효한 정수로 변환될 수 있으면 해당 Int 값을 반환하고, 그렇지 않으면 null을 반환
    val number = value.toIntOrNull() ?: throw IllegalArgumentException("잘못된 문자열 형식이 포함되어 있어요: '$value'")
    // 양수가 아닌 경우 예외 발생
    if (number <= 0) {
        throw IllegalArgumentException("양수만 입력해 주세요.")
    }
    return number
}
