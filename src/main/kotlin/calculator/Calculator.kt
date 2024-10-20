package calculator

import camp.nextstep.edu.missionutils.Console

class Calculator(private val requestMessage: String, private val defaultDelimiters: MutableSet<Char>) {
    private var input = ""
    private var delimiters = mutableSetOf<Char>()
    private var operands = mutableListOf<BigInt>()

    init {
        requestInput(requestMessage)
        parseInput(input)
    }

    /**
     * 주어진 BigInt 리스트의 합을 계산하여 출력합니다.
     *
     * @param responseMessage 결과 메시지의 첫 부분에 출력될 문자열 (ex - "결과 : ")
     * @param numberList 합계를 구할 수들의 리스트
     */
    fun printSum(responseMessage: String) {
        var sum = BigInt("0")
        operands.forEach { number -> sum = BigInt.add(sum, number) }
        println("$responseMessage$sum")
    }

    /**
     * 콘솔에 requestMessage를 출력하고, 문자열을 입력받습니다.
     *
     * @param requestMessage 문자열 입력을 요청하기 위해 사용자에게 표시되는 메시지
     * */
    fun requestInput(requestMessage: String) {
        println(requestMessage)
        input = Console.readLine()
    }

    /**
     * 주어진 문자열을 파싱하여, 피연산자인 숫자들의 리스트로 반환합니다.
     *
     * @param input 사용자로부터 입력받은 문자열
     * @return 파싱된 수들의 리스트
     */
    private fun parseInput(input: String) {
        var expression = input

        // 커스텀 구분자 입력 부분 검사
        if (input.startsWith("//")) {
            val separateIndex = input.lastIndexOf("\\n")
            if (separateIndex == -1) throw IllegalArgumentException()

            val customDelimiterInput = input.substring(2, separateIndex)
            expression = input.substring(separateIndex + 2)

            validateCustomDelimiterInput(customDelimiterInput)
            delimiters = parseCustomDelimiterInput(customDelimiterInput)

            validateExpression(expression, delimiters)
            operands = parseExpression(expression, delimiters)
        } else {
            validateExpression(expression, defaultDelimiters)
            operands = parseExpression(expression, defaultDelimiters)
        }
    }

    /**
     * 커스텀 구분자 입력을 구분자 집합에 추가하여 반환합니다.
     *
     * @param customDelimiterInput 커스텀 구분자 문자열
     * @return 구분자가 추가된 집합
     */
    private fun parseCustomDelimiterInput(customDelimiterInput: String): MutableSet<Char> {
        val set = defaultDelimiters
        for (char in customDelimiterInput) {
            set.add(char)
        }
        return set
    }

    /**
     * 주어진 expression(수식 문자열)을 구분자로 split하여 BigInt 리스트로 반환합니다.
     *
     * @param expression 연산자와 구분자로 이루어진 수식 문자열
     * @param delimiters 구분자로 사용할 문자들의 리스트
     * @return 구분자를 기준으로 분리된 수들의 리스트
     */
    private fun parseExpression(expression: String, delimiters: MutableSet<Char>): MutableList<BigInt> {
        val numberList = mutableListOf<BigInt>()
        var number = mutableListOf<Char>()
        for (character in expression) {
            var isDelimiter = false
            if (delimiters.find { it == character } != null) {
                isDelimiter = true
            }
            if (isDelimiter) {
                numberList.add(BigInt(number.joinToString("")))
                number = mutableListOf<Char>()
                continue
            }
            number.add(character)
        }

        if (number.size > 0) numberList.add(BigInt(number.joinToString("")))
        return numberList
    }

    /**
     * 주어진 커스텀 구분자 입력에 대한 유효성 검사를 수행합니다.
     *
     * @param customDelimiterInput 커스텀 구분자 문자열
     */
    private fun validateCustomDelimiterInput(customDelimiterInput: String) {}

    /**
     * 주어진 expression의 유효성을 검사합니다.
     *
     * @param expression 피연산자와 구분자로 이루어진 수식 문자열
     * @param delimiters 구분자 집합
     */
    private fun validateExpression(expression: String, delimiters: MutableSet<Char>) {
        var prevCharacter: Char? = null

        for (currentCharacter in expression) {
            var isDelimiter = false
            if (currentCharacter in delimiters) {
                isDelimiter = true
            }

            if (isDelimiter) {
                // expression의 첫 번째 character로 구분자가 나타난 경우
                if (prevCharacter == null) throw IllegalArgumentException()
                // 구분자가 연속 두 번 나타난 경우
                if (prevCharacter in delimiters) throw IllegalArgumentException()
            } else {
                // 피연산자이지만 숫자가 아닌 것을 입력받은 경우
                if (!currentCharacter.isDigit()) throw IllegalArgumentException()
            }
            prevCharacter = currentCharacter
        }
        // expression의 맨 마지막 character로 구분자가 나타난 경우
        if (prevCharacter in delimiters) throw IllegalArgumentException()
    }

}