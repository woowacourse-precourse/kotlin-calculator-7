package calculator

fun main() {
    val input: MutableList<String> = getInput("덧셈할 문자열을 입력해 주세요.")
}
/** 문자열을 입력받고, 이를 MutableList로 반환
 *
 * @param requestMessage 문자열 입력을 요청하기 위해 사용자에게 표시되는 메시지
 * */
fun getInput(requestMessage: String): MutableList<String> {
    println(requestMessage)

    var lines = mutableListOf<String>()
    lines.add(readlnOrNull() ?: "")
    lines.add(readlnOrNull() ?: "")

    return lines
}