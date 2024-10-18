package calculator

class InOutController {
    private fun checkCustomDivider(input: String): String? {
        var customDivider: String? = null
        if (input.startsWith("//")) {
            if (input.indexOf("\\n") != -1) {
                customDivider = input.substring(2, input.indexOf("\\n"))
            }
        } else customDivider = null

        return customDivider
    }
}