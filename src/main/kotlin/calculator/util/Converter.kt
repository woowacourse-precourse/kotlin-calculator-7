package calculator.util

class Converter {

    private fun hasCustomDelimiter(input: String): Boolean {
        return Constant.CUSTOM_DELIMITER_DETERMINE_REGEX.matches(input)
    }

}