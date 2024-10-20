package calculator

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {

    @Test
    fun testCalculateEmpty() {
        assertSimpleTest {
            run("")
            assertThat(output()).contains("결과 : 0")
        }
    }

    @Test
    fun testCalculateDelimiter() {
        assertSimpleTest {
            run("1,2:3")
            assertThat(output()).contains("결과 : 6")
        }
    }

    @Test
    fun testCalculateCustomDelimiter() {
        assertSimpleTest {
            run("//;\\n1;2;3")
            assertThat(output()).contains("결과 : 6")
        }
    }

    /*@Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("-1,2,3") }
        }
    }*/

    override fun runMain() {
        main()
    }
}
