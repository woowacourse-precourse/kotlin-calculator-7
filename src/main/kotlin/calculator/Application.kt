package calculator
import camp.nextstep.edu.missionutils.Console

fun main() {

    val input = Console.readLine()
    val result = numEmpty(input)

    println("결과 : $result")
}
// input이 빈문자열이거나 null값인지 확인하는 함수
fun numEmpty(input: String?): Int {
    if (input.isNullOrEmpty()) {
        return 0
    }
    return -1   // 임시반환값, 이후 기능에서 처리
}

