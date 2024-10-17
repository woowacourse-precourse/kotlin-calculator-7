package calculator.util

class Converter {
    
    private fun hasCustomDelimiter(input: String): Boolean {
        return Constant.CUSTOM_DELIMITER_DETERMINE_REGEX.matches(input)
    }

    // 입력에서 커스텀 정규표현식에 해당하는 그룹을 찾은 후 커스텀 구분자에 해당하는 groups[1]의 값을 반환한다.
    private fun extractCustomDelimiter(input: String): String {
        return Constant.CUSTOM_DELIMITER_DETERMINE_REGEX.find(input)!!.groups[1]!!.value
    }


}