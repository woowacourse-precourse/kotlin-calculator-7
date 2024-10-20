package calculator

/**
 * 문자열 덧셈 계산기 클래스
 * 문자열을 받아서 구분자에 따라 숫자를 추출하고 합산하는 기능을 담당합니다.
 */

class StringCalculator {
    /**
     * 입력된 문자열을 받아 숫자 합계를 계산하는 함수
     * @param input 사용자로부터 입력된 문자열
     * @return 숫자의 합계
     */

    fun add(input: String?): Int {
        val userInput = input?.trim().orEmpty()
        if (userInput.isEmpty()) {
            return 0
        }
        // 구분자 파싱 후 숫자 영역 추출 후 저장
        val (numbersArea, delimiters) = parseInput(userInput)

        //추출한 구분자를 기준으로 숫자들을 분리
        val numbers = splitNumbers(numbersArea, delimiters)
        return intSum(numbers)
    }

    /**
     * 입력 문자열에서 커스텀 구분자를 추출하고 숫자 영역을 반환하는 메서드
     * @param input 사용자 입력 문자열
     * @return Pair: 숫자 문자열과 구분자 리스트
     */
    private fun parseInput(input: String): Pair<String, List<String>> {

    }

    private fun splitNumbers(numbersArea: String, delimiters: List<String>): List<String> {

        return numbersArea.split(Regex(regexPattern))
    }
    private fun intSum(numbers: List<String>): Int {
        var sum = 0

        return sum
    }
}