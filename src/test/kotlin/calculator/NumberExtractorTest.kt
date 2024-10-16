package calculator

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NumberExtractorTest {
    private lateinit var numberExtractor: NumberExtractor

    @BeforeEach
    fun setup() {
        numberExtractor = NumberExtractor()
    }

    @Test
    fun `커스텀 구분자 추가 성공`() {
        val separator = ";"
        numberExtractor.addExtractor(separator)

        val separatorsField = NumberExtractor::class.java.getDeclaredField("separators")
        separatorsField.isAccessible = true;
        val separators = separatorsField.get(numberExtractor) as MutableList<*>

        assertTrue(separators.contains(separator))
    }

    @Test
    fun `커스텀 구분자 추가 실패 - 2글자 이상`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                numberExtractor.addExtractor(";;")
            }
        }
    }

    @Test
    fun `커스텀 구분자 추가 실패 - 0글자`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                numberExtractor.addExtractor("")
            }
        }
    }
}
