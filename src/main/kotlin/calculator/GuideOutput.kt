package calculator

const val DELIMITERS_MESSAGE = "기초 구분자는 ,(반점)과 :(콜론) 입니다. "
const val CUSTOM_DELIMITERS_MESSAGE = "커스텀 구분자 선언 방식 : //구분자\\n (예시 //;\\n3;6,8:7)"
const val ADDITION_INPUT_MESSAGE = "덧셈할 문자열을 구분자로 나눠서 입력해 주세요.(예시 1,3:5,6)"

class GuideOutput {
    fun guideDelimiters() = println(DELIMITERS_MESSAGE)

    fun guideCustomDelimiters() = println(CUSTOM_DELIMITERS_MESSAGE)

    fun guideAdditionInput() = println(ADDITION_INPUT_MESSAGE)
}