package calculator.model

class SumCalculator(private val numberList: List<Int>) {

    fun getSum(): Int {
        return numberList.sum()
    }
}
