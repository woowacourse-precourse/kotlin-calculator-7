package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    var result = 0
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine()

    if (input.isBlank()){
        result = 0
    }

    if (input.contains(",") || input.contains(":")) {
        // , 또는 : 구분자를 기준으로 분리한다.
        val numFromInput= input.split("," , ":").map { it.toInt() }

        // 조건에 맞는지 검사하기
        for (num in numFromInput){
            try {
                if (num <= 0) {
                    println("양수만 입력해주세요")
                    Console.close()
                    throw IllegalArgumentException("양수만 입력해주세요")
                }
            } catch (e: NumberFormatException){
                println("프로그램을 종료합니다.")
                Console.close()
                throw IllegalArgumentException()
            }
        }
        println(numFromInput)
    }
}
