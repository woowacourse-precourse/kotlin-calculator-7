package calculator
import camp.nextstep.edu.missionutils.Console

fun sumOfNumber(input : String) : Int{
    if (input.isEmpty()) return 0

    val customDelimiterPattern = """//(.)\n(.*)""".toRegex()
    val matchResult = customDelimiterPattern.matchEntire(input)

    return if (matchResult != null) {
        val delimiter = matchResult.groupValues[1]
        val numbers = matchResult.groupValues[2]
        numbers.split("[$delimiter,:]".toRegex()).sumOf { it.toInt() }
    } else {
        input.split("[,:]".toRegex()).sumOf { it.toInt() }
    }
}
fun main() {
    val input = Console.readLine()

}
