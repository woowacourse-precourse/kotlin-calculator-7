package calculator

// 입력 값에 대한 기본적인 유효성 검사
fun String.isNotEmptyOrThrow(): String =
    when {
        this.isEmpty() -> throw IllegalArgumentException()
        else -> this
    }

// 문자열 리스트를 정수형 리스트로 변환해준다.
fun List<String>.toPositiveIntList(): List<Int> =
    this.map {
        val intValue = it.toIntOrNull()
        if (intValue == null || intValue < 0) {
            throw IllegalArgumentException()
        }
        intValue
    }
