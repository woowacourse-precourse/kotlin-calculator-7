package calculator.view

import calculator.domain.DelimiterSplitter
import camp.nextstep.edu.missionutils.Console

class InputView {
    fun inputCommend(): DelimiterSplitter = DelimiterSplitter(Console.readLine())
}
