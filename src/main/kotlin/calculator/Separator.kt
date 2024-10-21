package calculator

class Separator {

    private val separators: MutableList<String> = mutableListOf(COMMA, COLON)
    fun extractCustomSeparator(originInput: String): Pair<String, MutableList<String>> {
        var parsedInput = originInput

        while (parsedInput.contains(CUSTOM_PREFIX) && parsedInput.contains(CUSTOM_SUFFIX)) {
            val prefixIndex = parsedInput.indexOf(CUSTOM_PREFIX) + CUSTOM_PREFIX.length
            val suffixIndex = parsedInput.indexOf(CUSTOM_SUFFIX)
            val customSeparator = parsedInput.substring(prefixIndex, suffixIndex)

            customSeparator.takeIf { it.isNotEmpty() }
                ?: throw IllegalArgumentException(ErrorMessages.CUSTOM_SEPARATOR_NOT_PROVIDED)

            if (prefixIndex < suffixIndex) {
                separators.takeIf { !it.contains(customSeparator) }?.add(customSeparator)
                parsedInput = parsedInput.substring(suffixIndex + CUSTOM_SUFFIX.length)
            } else {
                throw IllegalArgumentException(ErrorMessages.INVALID_CUSTOM_FORMAT)
            }
        }

        return Pair(parsedInput, separators)
    }

    companion object Separators {
        private const val COMMA = ","
        private const val COLON = ":"
        private const val CUSTOM_PREFIX = "//"
        private const val CUSTOM_SUFFIX = "\\n"
    }
}