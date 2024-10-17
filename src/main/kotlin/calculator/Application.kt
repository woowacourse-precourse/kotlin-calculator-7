package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    // 입력 받기
    println("덧셈할 문자열을 입력해 주세요.")
    var input:String = Console.readLine().toString();

    // 구분자 리스트 생성
    var sepList = mutableListOf<Char>(':',',');

    // 추가 구분자 구성
    if (input.length >= 5){
        if (input[0] == '/' && input[1] == '/' && input[3] == '\\' && input[4] == 'n'){
            sepList.add(input[2]);
            input = input.substring(5);
        }
    }

    // 덧셈 계산기
    var num = 0
    var answer = 0

    for(c in input){
        if(sepList.contains(c)){
            answer += num
            num = 0
            continue
        }
        num = (num * 10) + (c.code - '0'.code)
    }
    answer += num

    print("결과 : $answer");
}

