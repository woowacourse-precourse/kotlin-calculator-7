package calculator

val List<Double>.areAllPositive: Boolean
    get() = all { it > 0 }