package calculator

class Calculator {
    companion object {
        //기능4. 유효한 숫자들의 덧셈을 반환
        fun sumNumbers(): Int {
            return ValidData.validNumbers.sum()
        }
    }
}