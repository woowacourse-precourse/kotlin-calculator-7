package calculator

class GuideOutput {
    fun guideDelimiters() = println("기초 구분자는 ,(반점)과 :(콜론) 입니다. ")

    fun guideCustomDelimiters() = println("커스텀 구분자 선언 방식 : //구분자\\n (예시 //;\\n3;6,8:7)")

    fun guideAdditionInput() = println("덧셈할 문자열을 구분자로 나눠서 입력해 주세요.(예시 1,3:5,6)")
}