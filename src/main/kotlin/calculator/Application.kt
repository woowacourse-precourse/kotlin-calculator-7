package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.");
    val input: String = Console.readLine();
    var textArray: List<String>;

    if (input.contains("//") && input.contains("\\n")) {
        if (input.startsWith("//")) {
            val temp = input.split("//", "\\n");
            textArray = temp[2].split(temp[1], ",", ":");
        } else {
            throw IllegalArgumentException("잘못된 입력입니다.");
        }
    } else if (input == ""){
        textArray = listOf("0");
    } else {
        textArray = input.split(",", ":");
    }

    var result: Int? = 0;
    try {
        textArray.forEach {
            if (Integer.parseInt(it) > 0) {
                result = result?.plus(Integer.parseInt(it));
            } else {
                throw IllegalArgumentException("잘못된 입력입니다.");
            }
        }
    } catch (e: NumberFormatException) {
        result = null;
    }

    if (result == null) {
        throw IllegalArgumentException("잘못된 입력입니다.");
    } else {
        println("결과 : $result");
    }
}
