package calculator
import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    val input: String = readLine()  // 문자열 입력 받기
    val delimiter: Set<Char> = DelimiterParser.getDelimiter(input) //구분자 Set 추출 하기
}
