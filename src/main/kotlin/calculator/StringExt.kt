package calculator

fun String.isNotNumeric(): Boolean {
    return this.toDoubleOrNull() == null
}
