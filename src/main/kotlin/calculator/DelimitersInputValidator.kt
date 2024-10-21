package calculator

class DelimitersInputValidator {

    fun delimitersInputErrorCheck(userInput: String): String {

        if (userInput.isBlank()) {
            throw IllegalArgumentException("입력 하지 않았습니다.")
        }

        if (!userInput.matches(Regex("[\\d:,+]"))) {
            throw IllegalArgumentException("기본구분자와 숫자를 제외한 다른 문자가 입력되었습니다.")
        }

        return userInput
    }
}