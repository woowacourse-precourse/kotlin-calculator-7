package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {

    // 문자열 입력 받기 (구분자와 양수로 구성된 문자열)
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine()

    // 구분자를 통한 숫자 추출
    val splitResult = splitInputData(input)

    // 덧셈 결과 출력
    println("결과 : ${sumNumber(splitResult)}")
}

fun splitInputData(input: String): MutableList<Int> {

    var resultList = mutableListOf<Int>()

    // 아무 값도 입력되지 않은 경우 0 반환
    if(input.isBlank()) return resultList

    // 커스텀 구분자가 존재하지 않는 경우
    if(input.startsWith("//")) {
        val endIndex = input.indexOf("\\n")

        // 해당 구분자가 없는 경우
        if(endIndex == -1) throw IllegalArgumentException("잘못된 값입니다. (구분자와 양수로 구성된 문자열 입력)")
        val customCharacter = input.substring(2, endIndex)
        val deletedCustomCharacter = input.substring(endIndex+2, input.length)
        val splitInputData = deletedCustomCharacter.split(customCharacter)

        resultList = checkCharacter(splitInputData)
    } else {
        // 기본 구분자(쉼표, 콜론)을 통한 문자열 구분
        val splitInputData = input.split(":", ",")

        resultList = checkCharacter(splitInputData)
    }

    return resultList
}

fun checkCharacter(splitInputData: List<String>): MutableList<Int> {
    var splitIntegerData = mutableListOf<Int>()

    for (i in splitInputData.indices) {
        // 구분자를 여러번 입력하거나 마지막에 입력한 경우
        if (splitInputData[i].isNotBlank()) {
            // 잘못된 값을 입력한 경우
            splitInputData[i].toIntOrNull()
                ?: throw IllegalArgumentException("잘못된 값입니다. (구분자와 양수로 구성된 문자열 입력)")
            // 음수를 입력한 경우
            if (splitInputData[i].toInt() < 0) throw IllegalArgumentException("잘못된 값입니다. (구분자와 양수로 구성된 문자열 입력)")
            splitIntegerData.add(splitInputData[i].toInt())
        } else {
            continue
        }
    }

    return splitIntegerData
}

fun sumNumber(inputNumber: MutableList<Int>): Int {

    return inputNumber.sumOf{ it }
}