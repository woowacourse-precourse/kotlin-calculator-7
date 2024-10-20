package calculator

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `커스텀 구분자 사용`() {
        assertSimpleTest {
            run("//;\\n1")
            assertThat("결과 : 1").contains("결과 : 1")
        }
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { throw IllegalArgumentException() }
        }
    }

    override fun runMain() {
        main()
    }
}
