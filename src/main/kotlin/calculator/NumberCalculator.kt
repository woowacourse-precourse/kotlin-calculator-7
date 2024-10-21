package calculator

object NumberCalculator {
    // list의 크기만큼 합산을 계산하는 함수
    fun addNumbers(userInput: String?): Int{
        val numberList = Validator.returnNumber(userInput!!)
        var result = 0
        for(i in numberList.indices){
            result+= numberList[i]
        }
        return result
    }
}