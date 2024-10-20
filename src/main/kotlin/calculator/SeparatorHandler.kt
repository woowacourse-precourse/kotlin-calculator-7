package calculator

class SeparatorHandler(private val input: String) {

    private fun isExitCustomSeparator(): Boolean {
        return input.startsWith("//") && input.contains("\n")
    }
}