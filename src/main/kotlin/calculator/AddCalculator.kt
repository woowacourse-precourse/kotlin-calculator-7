package calculator

class AddCalculator {
    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) {
            return 0
        }
        val delimiter = getDelimiter(input)
        val numbers = splitNumbers(input, delimiter)
        return numbers.sum()
    }

    fun getDelimiter(input: String): String {
        TODO()
    }
    fun splitNumbers(input:String, delimiter:String):List<Int>{
        TODO()
    }
    fun checkCustom(input:String):Boolean{
        TODO()
    }
}