package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    var result = 0
    val customSplit:String
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine()

    if (input.isBlank()){
        result = 0
    }

    else if (input.contains(",") || input.contains(":")) {
        // , 또는 : 구분자를 기준으로 분리한다.
        val numFromInput= input.split("," , ":").map { it.toInt() }

        // 조건에 맞는지 검사하기
        for (num in numFromInput){
                if (num <= 0) {
                    Console.close()
                    println("양수만 입력해주세요. 프로그램을 종료합니다.")
                    throw IllegalArgumentException("양수만 입력해주세요")
                }
        }
        result=numFromInput.sum()
    }

    else if (input.contains("//") || input.contains("\\n")) {
        // 커스텀 구분자  : 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자
        val lastIndex = input.lastIndexOf("\\n")

        // 커스텀 구분자를 찾기 위해 문자열을 자른다.
        customSplit = input.substring(2, lastIndex)

        // 문자열을 커스텀 구분자로 분리한 후 int형으로 변환해준다.
        val numFromInput = input.substring(lastIndex + 2).split(customSplit).map { it.toInt() }
        for (num in numFromInput) {
            if (num <= 0 ){
                    Console.close()
                println("양수만 입력해주세요. 프로그램을 종료합니다.")
                throw IllegalArgumentException("양수만 입력해주세요")
            }
        }
        result = numFromInput.sum()
    }

    println("결과 : $result")
}
