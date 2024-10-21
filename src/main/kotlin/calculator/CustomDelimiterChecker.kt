package calculator

class CustomDelimiterChecker {

    fun customDelimiterTest(userInput: String): Boolean {
        return userInput.startsWith("//") && userInput.contains("\\n")
    }
}
