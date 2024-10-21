package calculator

import java.math.BigDecimal

class ResultOutput {

    fun outputAddition(sum: BigDecimal) = println(ADDITION_RESULT_MESSAGE.format(sum))

    fun outputCustomDelimiters(delimiters: List<String>) = println(CUSTOM_DELIMITERS_RESULT_MESSAGE.format(delimiters))

    companion object{
        const val ADDITION_RESULT_MESSAGE = "입력하신 수의 총합 결과 : %s 입니다"
        const val CUSTOM_DELIMITERS_RESULT_MESSAGE = "입력하신 커스텀 구분자는 %s 입니다"
    }
}