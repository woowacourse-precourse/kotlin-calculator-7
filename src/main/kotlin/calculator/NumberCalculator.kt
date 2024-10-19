package calculator

object NumberCalculator {
    fun addNumbers(userInput: String?): Int{
        val numberList = Validator.returnNumber(userInput!!)
        var result = 0
        for(i in numberList.indices){
            result+= numberList[i]
        }
        return result
    }
}