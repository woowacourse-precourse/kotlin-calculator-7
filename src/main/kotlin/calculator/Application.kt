package calculator
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val inputStr = Console.readLine()
    val result = calculate(inputStr)

    if (result % 1 == 0f) {
        println("결과 : ${result.toInt()}")
    } else {
        println("결과 : $result")
    }
}

fun calculate(inputStr : String) : Float{
    val numbers = setString(inputStr)
    var result = 0f

    for(num in numbers){
        val n = num.toFloatOrNull() //숫자가 아닌 값들은 null로 변환

        if (n == null || n <= 0 ) { //양수가 아닌 값들이 존재할 경우
            throw IllegalArgumentException("잘못된 입력입니다")
        }
        result+=n
    }
    return result

}
fun setString(str : String) : List<String>{
    val numbers : List<String>

    //커스텀 구분자 확인
    if(str.startsWith("//") && str.contains("\\n")){
        val start = 2
        val end = str.indexOf("\\n")
        if(end-start<=0){
            throw IllegalArgumentException("커스텀 구분자가 입력되지 않았습니다.")
        }
        else{
            val customSplit = str.substring(start, end)
            numbers = str.substringAfter("\\n").split(",",":",customSplit)
        }
    }
    else{
        numbers = str.split(',',':')
    }
    if (str.isEmpty()) {
        throw IllegalArgumentException("입력된 숫자가 없습니다.")
    }
    return numbers
}