package calculator.calculator

class Calculator {
    fun calculateInput(listOfInput: List<String>): Int {
        val intListOfInput = changeInt(listOfInput)
        val sum = sumInput(intListOfInput)
        return sum
    }

    private fun changeInt(listOfInput: List<String>): List<Int> {
        var intListOfInput = mutableListOf<Int>()
        for (element in listOfInput) {
            intListOfInput.add(element.toInt())
        }
        return intListOfInput
    }

    private fun sumInput(intListOfInput: List<Int>): Int {
        var sum = 0;
        for (element in intListOfInput) {
            sum += element
        }
        return sum
    }
}