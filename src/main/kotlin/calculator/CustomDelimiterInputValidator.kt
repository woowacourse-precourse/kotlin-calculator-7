package calculator

class CustomDelimiterInputValidator {

    fun customDelimitersInputErrorCheck(userInput: String): String {
        val customDelimiter = userInput.substring(2, userInput.indexOf("\\n"))

        if (customDelimiter.matches(Regex("\\d+"))) {
            throw IllegalArgumentException("커스텀구분자로 숫자를 이용할 수 없습니다.")
        }

        if (userInput.indexOf("\\n") == 2) {
            throw IllegalArgumentException("커스텀구분자를 입력하지 않았습니다.")
        }

        val customDelimiterRemovedUserInput = userInput.substring(userInput.indexOf("\\n") + 2)

        if (!customDelimiter.matches(Regex("[a-zA-Z가-힣]+")) &&
            customDelimiterRemovedUserInput.matches(Regex("[a-zA-Z가-힣]+")))
        {
            throw IllegalArgumentException("커스텀구분자로 지정되지 않은 문자가 입력되었습니다.")
        }

        if (!customDelimiterRemovedUserInput.matches(Regex("[\\d:,]+")) &&
            !customDelimiterRemovedUserInput.contains(customDelimiter))
        {
            throw IllegalArgumentException("기본구분자와 숫자를 제외한 다른 문자가 입력되었습니다.")
        }

        return userInput
    }
}