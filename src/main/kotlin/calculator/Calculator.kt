package calculator

class Calculator(var input:String) {
    val list : MutableList<Char> = mutableListOf(',',':')
    var numberList : MutableList<Int>  = mutableListOf()
    var tmpNumber = 0
    fun findSeparator(){
        if(input[0]=='/'&&input[1]=='/'&&input[3]=='\\'&&input[4]=='n') {
            list.add(input[2])
            input = input.substring(5)
        }
    }
    fun findNumber(){
        var nowNumber = ""
        for(j in input){
            if(list.contains(j)){
                numberList.add(toNumber(nowNumber))
                nowNumber = ""
            }
            else{
                nowNumber += j
            }
        }
        numberList.add(toNumber(nowNumber))
    }

    fun toNumber(nowNumber:String):Int{
        return try{
            nowNumber.toInt()
        } catch(e : IllegalArgumentException){
            throw Exception(e)
        }
    }
    fun plus(){
        for( i in numberList){
            tmpNumber += i
        }
    }
    
    fun print(){
        println(tmpNumber)
    }
}