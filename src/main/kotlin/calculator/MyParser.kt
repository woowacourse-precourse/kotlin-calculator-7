package calculator

class MyParser {
    companion object {
        private val defaultDelimiters = listOf(",", ":")
        private val delimiterInputRegex = "(//(.+)\\\\n)?(.*)".toRegex()
    }
}
