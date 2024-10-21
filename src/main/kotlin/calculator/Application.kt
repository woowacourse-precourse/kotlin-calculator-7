package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.");
    val input: String = Console.readLine();
    var textArray: List<String>;

    if (input.contains("//") && input.contains("\\n")) {
        val temp = input.split("//", "\\n");
        textArray = temp[2].split(temp[1], ",", ":");
    } else {
        textArray = input.split(",", ":");
    }

    var result = 0;
    textArray.forEach {
        result += Integer.parseInt(it);
    }
    println(result);
}
