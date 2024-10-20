package calculator
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val inputStr = Console.readLine()
    val result = calculate(inputStr)

    //결과값에 소숫점 아래 자리 수가 없다면 정수형으로 변환 후 출력
    if (result % 1 == 0f) {
        println("결과 : ${result.toInt()}")
    } else {
        println("결과 : $result")
    }
}

fun calculate(inputStr : String) : Float{

    var result = 0f
    //사용자가 빈 문자열 입력 시
    if(inputStr=="") return result

    //문자열을 구분자로 나눠 numbers에 저장
    val numbers = setString(inputStr)
    for(num in numbers){

        //저장된 값을 float로 변환하고 숫자가 아니면 null로 변환
        val n = num.toFloatOrNull()

        //값이 양수가 아니거나 null이면 Error
        if (n == null || n <= 0 ) {
            throw IllegalArgumentException("잘못된 입력입니다 : \"${num}\"")
        }
        result+=n
    }
    return result
}

//문자열을 구분자로 나누어 리스트에 저장하는 함수
fun setString(str : String) : List<String>{

    val numbers : List<String>

    // 커스텀 구분자 존재 여부를 확인
    if(str.startsWith("//") && str.contains("\\n")){
        val start = 2
        val end = str.indexOf("\\n")

        val customSplit = str.substring(start, end)

        //입력된 커스텀 구분자가 없으면 Error
        checkException(customSplit, "커스텀 구분자")

        val subStr = str.substringAfter("\\n")

        //커스텀 구분자 뒤에 입력된 값이 없으면 Error
        checkException(subStr)
        numbers = subStr.split(",",":",customSplit)
    }
    else{
        numbers = str.split(',',':')
    }

    return numbers
}

fun checkException(str : String, content : String = "값"){
    if (str.isEmpty()) {
        throw IllegalArgumentException("입력된 ${content}이(가) 없습니다.")
    }

}