package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현
    var sum = 0
    val n :Int
    var num = 0

    var arr = arrayOf(',',':')
    var a = 0
    val inp = readLine()

    if(inp==""||inp==null){
        println("결과 : 0")
        return
    }
    n = inp.length
    if(inp[0]=='/'&&inp[1]=='/'){
        arr+=inp[2]
        a=5
    }

    for(i: Int in a..<n){
        try{
            num = num*10 + inp[i].toString().toInt()
        }catch(e:NumberFormatException){
            if(inp[i] in arr){
                sum += num
                num=0
            }else{
                throw IllegalArgumentException("")
            }
        }
    }
    sum += num
    println("결과 : "+sum)
}
