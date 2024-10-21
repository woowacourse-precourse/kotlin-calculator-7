package calculator

class GuideOutput {
    fun guideDelimiters() = println(DELIMITERS_MESSAGE)

    fun guideCustomDelimiters() = println(CUSTOM_DELIMITERS_MESSAGE)

    fun guideAdditionInput() = println(ADDITION_INPUT_MESSAGE)

    companion object {
        private const val DELIMITERS_MESSAGE = "기초 구분자는 ,(반점)과 :(콜론) 입니다. "
        private const val CUSTOM_DELIMITERS_MESSAGE = "커스텀 구분자 선언 방식 : //구분자\\n (예시 //;\\n3;6,8:7)"
        private const val ADDITION_INPUT_MESSAGE = "덧셈할 양수를 구분자로 나눠서 입력해 주세요.(예시 1,3:5,6)"
    }
}