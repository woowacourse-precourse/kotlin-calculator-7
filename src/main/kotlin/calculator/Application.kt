package calculator

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = readLine() ?: ""

    if (input.isEmpty()) {
        println("결과 : 0")
        return
    }

    // 커스텀 구분자 처리 및 숫자 추출
    val numberString = if (input.startsWith("//")) {
        val customDelimiter = input.substringAfter("//").substringBefore("\n")
        input.substringAfter("\n")
    } else {
        input
    }

    // 음수 체크를 위한 정규식
    if (numberString.contains(Regex("-\\d"))) {
        throw IllegalArgumentException("음수는 허용되지 않습니다.")
    }

    // 0-9를 제외한 모든 문자를 '+'로 대체
    val processedInput = numberString.replace(Regex("[^0-9]+"), "+")

    // '+'로 문자열을 분리하고 빈 문자열은 제거
    val numbers = processedInput.split("+").filter { it.isNotEmpty() }

    if (numbers.isEmpty()) {
        throw IllegalArgumentException("숫자가 포함되어 있지 않습니다.")
    }

    var sum = 0

    for (num in numbers) {
        val parsedNumber = num.toIntOrNull()
        if (parsedNumber == null) {
            throw IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: $num")
        }
        sum += parsedNumber
    }

    println("결과 : $sum")
}