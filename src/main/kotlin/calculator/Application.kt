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
        // 구분자 출력
        print("delimiters: $delimiters")
        // parts[1]을 기준으로 숫자를 분리
        numbers = parts[1].split(*delimiters.toTypedArray())

    } else {
        numbers = input.split(*delimiters.toTypedArray())
    }

    // 출력
    println(numbers)
}
