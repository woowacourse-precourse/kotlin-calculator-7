package calculator

fun String.isNotNumeric(): Boolean {
    return this.toDoubleOrNull() == null
}

fun String.isNegativeNumber(): Boolean {
    return this.toIntOrNull()?.let { it < 0 } ?: false
}