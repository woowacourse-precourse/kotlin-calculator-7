package calculator

fun main() {
    // 정규식
    val regexExpression = "^[0-9,:]+$"
    val regex = regexExpression.toRegex()


    // 입력 값
    val exampleInput = "12:3,4,2" // "" "1,2" "1,2,3" "1,2:3"
    println("덧셈할 문자열을 입해 주세요.")
    println(exampleInput)

    // 입력값 검사
    if (!regex.matches(exampleInput)) throw IllegalArgumentException("잘못된 입력 값을 입력하였습니다. ([0-9], [,], [:], [커스텀구분자]) 만 입력 가능합니다.")
    val input = exampleInput.split(",", ":")

    // field
    var result = 0

    // 계산기
    for (i in input) {
        result += i.toInt()
    }

    // 결과값 출력
    println("결과 : $result")
}
