package calculator

class ExceptionManager {
    fun Input(input: String) {
        if(input.contains("//") && !input.contains("\\n") || input.contains("\\n") && !input.contains("//")){
            throw IllegalArgumentException("커스텀 구분자 양식을 지켜주세요.")
        }
        if(!isContainNumber(input)){
            throw IllegalArgumentException("숫자를 함께 입력해주세요.")
        }
        if(input.toIntOrNull() != null){
            throw IllegalArgumentException("숫자와 구분자를 함께 입력해주세요.")
        }
    }
    private fun isContainNumber(input: String):Boolean{
        val regex = Regex("\\d") // \\d는 숫자를 의미하는 정규 표현식
        return regex.containsMatchIn(input)
    }
}