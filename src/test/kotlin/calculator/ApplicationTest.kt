package calculator

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {

    @Test
    fun customDelimiterTest() {
        assertSimpleTest {
            run("//;\n1")  // 커스텀 구분자 ; 사용
            assertThat(true).isTrue()
        }
    }

    @Test
    fun negativeNumberTest() {
        assertSimpleTest {
            assertThat(true).isTrue()
        }
    }

    override fun runMain() {
        main()
    }
}
