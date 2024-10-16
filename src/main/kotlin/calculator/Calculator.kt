package calculator

class Calculator(var input:String) {
    val list : MutableList<Char> = mutableListOf(',',':')
    var numberList : MutableList<Int>  = mutableListOf()
    fun findSeparator(){
        if(input[0]=='/'&&input[1]=='/'&&input[3]=='\\'&&input[4]=='n') {
            list.add(input[2])
            input.substring(5)
        }
    }
    

}