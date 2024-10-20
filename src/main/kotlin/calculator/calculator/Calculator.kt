package calculator.calculator

class Calculator {
    fun calculateInput(doneValidation: List<String>): Int {
        val intListOfInput = changeInt(doneValidation)
        val sum = sumUserInput(intListOfInput)
        return sum
    }

    private fun changeInt(doneValidation: List<String>): List<Int> {
        var intListOfUserInput = mutableListOf<Int>()
        for (element in doneValidation) {
            intListOfUserInput.add(element.toInt())
        }
        return intListOfUserInput
    }

    private fun sumUserInput(intListOfUserInput: List<Int>): Int {
        var sum = 0;
        for (element in intListOfUserInput) {
            sum += element
        }
        return sum
    }
}