package calculator

// 일반적인 String 문자열을 처리하는 메소드를 가지는 객체
object StringUtility {
    // 컬렉션 타입으로 저장된 구분자를 이용해 String 분할하는 확장함수
    fun <T> String.splitByCollection(delimiters: Collection<T>): List<String> {
        // 구분자들을 이스케이프 처리하고 정규식 OR(|)로 결합
        val escapedDelimiters = delimiters.map {
            when (it) {
                is Char -> Regex.escape(it.toString())
                is String -> Regex.escape(it)
                else -> throw IllegalArgumentException("지원하지 않는 구분자 타입 입니다.")
            }
        }
        val regex = escapedDelimiters.joinToString("|").toRegex()
        // 정규식을 사용해 문자열을 분할
        return this.split(regex)
    }
}