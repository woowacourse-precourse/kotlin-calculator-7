package calculator

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    val stringPlusCalculator = StringPlusCalculator()
    stringPlusCalculator.execute {
        readLine()
    }
}
