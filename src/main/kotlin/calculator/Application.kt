package calculator

fun main() {
    val delimiters = mutableListOf(",", ":") // 기본 구분자
    var numbers: List<String> = emptyList()
    // 입력 받기
    val input = readlnOrNull() ?: ""

    // 입력의 시작이 `//`로 시작한다면
    if (input.startsWith("//")) {
        // "\n" 기준으로 나누기
        val parts = input.split("\\n")
        // 사용자 지정 구분자 추출
        val customDelimiter = parts[0].substring(2) // "//" 제거
        // 구분자 업데이트
        delimiters += customDelimiter
        // 나머지 부분에서 숫자 분리
        if (parts.size > 1) {
            // parts[1]을 기준으로 숫자를 분리
            numbers = parts[1].split(*delimiters.toTypedArray())
        }
    } else {
        // 기본 구분자를 사용하여 숫자 분리
        numbers = input.split(*delimiters.toTypedArray())
    }

    // 숫자를 정수로 변환하고 합계 계산
    val sum = numbers.sumOf {
        // 숫자가 아닌 경우 IllegalArgumentException 발생
        val number = it.toIntOrNull() ?: throw IllegalArgumentException("[잘못된 입력입니다: $it]")
        number
    }

    // 합계 출력
    println("합계: $sum")
}
