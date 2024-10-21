package calculator

import org.junit.jupiter.api.Assertions.*
import org.assertj.core.api.Assertions.assertThat // AssertJ 사용
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class DelimiterExtractorTest {

    private val extractor = DelimiterExtractor()

    @Test
    fun `커스텀 구분자가 있을 때 구분자와 숫자 문자열을 추출`() {
        val input = "//;\\n1;2;3"

        val result = extractor.extract(input)

        assertThat(result.first).isEqualTo(Regex.escape(";")+"|,|:")
        assertThat(result.second).isEqualTo("1;2;3")
    }

    @Test
    fun `커스텀 구분자가 여러개 있을 때 구분자들을 여러개 추출`() {
        val input = "//!@\\n1!2@3"

        val result = extractor.extract(input)

        assertThat(result.first).isEqualTo(Regex.escape("!")+"|"+Regex.escape("@")+"|,|:")
        assertThat(result.second).isEqualTo("1!2@3")
    }

    @Test
    fun `기본 구분자를 사용할 때 구분자와 숫자 문자열을 추출`() {
        val input = "1,2:3"

        val result = extractor.extract(input)

        assertThat(result.first).isEqualTo(",|:")
        assertThat(result.second).isEqualTo("1,2:3")
    }

    @Test
    fun `커스텀 구분자 없이 숫자만 입력했을 때 기본 구분자로 처리`() {
        val input = "4,5:6"

        val result = extractor.extract(input)

        assertThat(result.first).isEqualTo(",|:")
        assertThat(result.second).isEqualTo("4,5:6")
    }

    @Test
    fun `숫자가 없는 경우 예외 발생`() {
        val input = "//;\\na;b;c"

        val exception = assertThrows<IllegalArgumentException> {
            extractor.extract(input)
        }
        assertThat(exception.message).isEqualTo("숫자를 입력해주세요.")
    }
}
