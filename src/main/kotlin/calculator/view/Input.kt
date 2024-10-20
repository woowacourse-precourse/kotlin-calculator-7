package calculator

import camp.nextstep.edu.missionutils.Console

object Input {
    fun inputStringData():String {
        println("덧셈할 문자열을 입력해 주세요.")
        try {
            val inputData = Console.readLine()
            return inputData
        }catch (e: NoSuchElementException){
            return "0";
        }

    }
}