package calculator.calculator

class Calculator {
    fun calculateInput(listOfInput: List<String>): Int {
        val intListOfInput = changeInt(listOfInput)
        return 0
    }

    private fun changeInt(listOfInput: List<String>): List<Int> {
        var intListOfInput = mutableListOf<Int>()
        for (element in listOfInput) {
            intListOfInput.add(element.toInt())
        }
        return intListOfInput
    }
}