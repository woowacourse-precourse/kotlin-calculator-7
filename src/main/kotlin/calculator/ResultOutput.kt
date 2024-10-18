package calculator

import java.math.BigDecimal

class ResultOutput {

    fun outputAddition(sum: BigDecimal) = println("입력하신 수의 총합은 $sum 입니다")

    fun outputCustomDelimiters(delimiters: List<String>) = println("입력하신 커스텀 구분자는 $delimiters 입니다")
}