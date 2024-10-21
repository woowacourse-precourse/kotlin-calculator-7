package calculator

class PlusCalculator : Calculator {

    /**
     * 파싱된 숫자들을 계산해주는 역할
     */
    override fun execute(numbers: List<Long>): Long {
        var sum = 0L
        numbers.forEach {
            sum += it
        }
        return sum
    }
}