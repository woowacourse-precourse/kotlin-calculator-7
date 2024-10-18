package calculator.model

class Divider {
    fun checkDivider(inputValue: String): Int {
        when {
            isDefault(inputValue) -> return 0
            isCustom(inputValue) -> return 1
        }
        return 2
    }

    private fun isDefault(inputValue: String): Boolean {
        return !isCustom(inputValue) && inputValue.contains(",") || inputValue.contains(":")
    }

    private fun isCustom(inputValue: String): Boolean {
        return (inputValue.substring(0, 1) == "//" && inputValue.substring(3, 4) == "\n")
    }
}
