package calculator

fun main() {
    // TODO: 프로그램 구현
    val inp = readln()
    var sum = 0
    val n = inp.length
    var num = 0

    var arr = arrayOf(',',':')
    var a = 0

    if(inp==""){
        println("결과 : 0")
        return
    }
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
