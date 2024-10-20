package calculator

object StringUtility {
    /**
     * 컬렉션 타입으로 저장된 구분자를 이용해 String 분할
     * @param delimiters Char, String타입의 구분자들이 들어있는 컬렉션
     * @throws IllegalArgumentException 지원되지 않는 구분자 타입인 경우
     * @return 분할된 문자열 리스트
     */
    fun <T> String.splitByCollection(delimiters: Collection<T>): List<String> {
        // 구분자들을 이스케이프 처리한뒤 OR(|)로 결합한 정규식 작성하여 분할
        val escapedDelimiters = delimiters.map {
            when (it) {
                is Char -> Regex.escape(it.toString())
                is String -> Regex.escape(it)
                else -> throw IllegalArgumentException(ErrorType.INVALID_DELIMITER_TYPE.message)
            }
        }
        val regex = escapedDelimiters.joinToString("|").toRegex()
        return this.split(regex)
    }
}