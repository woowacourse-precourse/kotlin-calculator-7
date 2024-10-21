package calculator

fun main() {

    //readLine() 표준 입력에서 한 줄을 읽어서 문자열로 반환해주는 표준 코틀린 함수
    //?: <엘비스 연산자> 왼쪽 표현식이 null이 아니면 그 값을 반환하고, null이면 오른쪽의 값을 반환합니다.
    val input = readLine() ?: ""
    try {
        val result = add(input)
        println("The sum is: $result")
    }catch (e: IllegalArgumentException){
        println(e.message)
        System.exit(1)//예외 발생 시 애플리케이션 종료
    }
}

fun add(input: String): Int {
    if (input.isBlank()) {
        return 0
    }

    val (delimiter, numbers) = if (input.startsWith("//")){
        // 커스텀 구분자를 처리하는 로직
        val customDelimiterEndIndex = input.indexOf("\n")
        if (customDelimiterEndIndex == -1) {
            throw IllegalArgumentException("Invalid input: missing newline after custom delimiter")
        }
        val customDelimiter = input.substring(2, customDelimiterEndIndex) // 커스텀 구분자를 추출
        customDelimiter to input.substring(customDelimiterEndIndex+1) // 숫자 부분을 추출
    } else {
        // 기본 구분자(쉼표 또는 콜론)를 사용하는 경우
        "[,|:]".toRegex() to input
    }

    // 커스텀 구분자와 기본 구분자를 구분하여 split
    return if (delimiter is Regex) {
        numbers.split(delimiter)
    } else {
        numbers.split(delimiter.toString())  // 커스텀 구분자 처리
    }.map { num ->
        num.toIntOrNull() ?: throw IllegalArgumentException("Invalid input: '$num'")  // 개별 숫자에 대한 예외 처리
    }.sum()
}
