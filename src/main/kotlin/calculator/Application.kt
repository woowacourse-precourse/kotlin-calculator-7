package calculator

import camp.nextstep.edu.missionutils.Console


fun main() {
    // TODO: 프로그램 구현
    // 문자열 입력받기
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine()

}
// 커스텀 구분자 사용 여부 확인 함수
fun isCustomDelimiter(input: String): Boolean {
    return input.startsWith("//")
}
}
