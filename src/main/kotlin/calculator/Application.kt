package calculator
import camp.nextstep.edu.missionutils.Console as con

fun main() {
    // TODO: 프로그램 구현

    println("덧셈할 문자열을 입력해 주세요.")
    //일단 읽어오기
    var texts: String = con.readLine().toString()


    //구분자 리스트
    var Separators = mutableListOf<String>()
    Separators.add(",")
    Separators.add(":")

    //길이가 5 이상이고, 시작 부분에 구분자를 양식에 맞게 추가 하였다면 구분자 추가
    if(texts.length>5 &&
        texts.substring(0, 1)=="/" &&
        texts.substring(1, 2)=="/"&&
        texts.substring(3, 4)=="\\"&&
        texts.substring(4, 5)=="n"){
        Separators.add((texts.substring(2, 3)))
    }

    
    //새로운 구분자가 있다면 구분자 부분은 넘기기
    if(Separators.size>2){
        texts=texts.substring(5)
    }

    //아래 반복문용 변수 i
    var i :Int=0;

    //입력 받은 값을 순회하기
    while (i <texts.length){
        var t : String= texts.substring(i, i+1)

        //구분자면 전부 , 로 바꾸기
        if(checkSeparators(t,Separators)){
            texts= texts.substring(0,i)+","+texts.substring(i+1)
        }
        i++

    }
    //합을 넣을 변수
    var total :Int=0
    //문자열을 분리하기
    var arr = texts.split(",")

    //분리된 문자열 순회하며 값들 더하기
    for (i in arr){
        try {
            total+=i.toInt()
        }
        catch (e: Exception){
            throw IllegalArgumentException()
        }
    }

    print("결과 : "+total)


}

//구분자인지 아닌지 확인하는 함수
fun checkSeparators(text: String, Separators: MutableList<String>): Boolean {
    for (i in Separators){
        if(text==i){
            return true
        }
    }
    return false
}

