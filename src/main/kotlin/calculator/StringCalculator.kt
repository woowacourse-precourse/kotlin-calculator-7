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
        // 커스텀 구분자가 있는경우, 개행 문자의 위치 찾아 구분자와 숫자 영역 분리
        return if (input.startsWith("//")) {
            val endIndex = input.indexOf("\n")
            if (endIndex == -1) {
                // 개행 문자 없으면 예외처리
                throw IllegalArgumentException("커스텀 구분자 지정이 잘못되었습니다.")
            }
            // "//" 다음부터 개행 문자까지의 문자열을 구분자로 추출 인덱스 하나만 뽑아내면 됨.
            val delimiter = input.substring(2, endIndex)
            // 개행 문자 이후부터의 문자열을 숫자 영역으로 추출
            val numberArea = input.substring(endIndex + 1)
            numberArea to listOf(delimiter)
        } else {
            // 기본 구분자 (쉼표, 콜론)를 사용하는 경우
            input to listOf(",", ":")
        }
    }

    /**
     * 주어진 숫자 영역을 구분자로 나누어 숫자 리스트를 반환하는 함수
     * @param numbersArea 구분자로 나눌 숫자 문자열
     * @param delimiters 숫자들을 나눌 구분자 목록
     * @return 구분자를 기준으로 분리된 숫자 문자열 리스트
     */
    private fun splitNumbers(numbersArea: String, delimiters: List<String>): List<String> {
        // 주어진 구분자 목록을 정규식 패턴으로 결합하여 숫자 영역을 구분자로 분리
        val regexPattern = delimiters.joinToString("|") { Regex.escape(it) }
        return numbersArea.split(Regex(regexPattern))
    }

    /**
     * 숫자 리스트를 받아 총합을 계산하는 함수
     * @param numbers 문자열 형태의 숫자 리스트
     * @return 리스트에 포함된 숫자들의 합
     * @throw IllegalArgumentException 숫자가 아닌 값이 있거나 음수 값이 포함된 경우 예외 발생
     */
    private fun intSum(numbers: List<String>): Int {
        var sum = 0
        for (numberStr in numbers) {
            // 예외처리
            val number = numberStr.toIntOrNull()
                ?: throw IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.")
            if (number < 0) {
                throw IllegalArgumentException("음수는 허용되지 않습니다.")
            }
            sum += number
        }
        return sum
    }
}