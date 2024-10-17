package calculator

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {

    @Test
    fun `valid input`() {
        assertSimpleTest {
            run("1,2,3")
            assertThat(output()).contains("결과: 6")
        }
    }

    @Test
    fun `empty string input`() {
        assertSimpleTest {
            // An empty string input means the user just presses enter.
            run("\n")
            assertThat(output()).contains("결과: 0")
        }
    }

    @Test
    fun `invalid input`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1,2,3,") }
        }
    }

    @Test
    fun `custom delimiter usage`() {
        assertSimpleTest {
            run("//;\\n1;3,3")
            assertThat(output()).contains("결과: 7")
        }
    }

    @Test
    fun `input contains negative numbers`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("-1,2,3") }
        }
    }

    override fun runMain() {
        main()
    }
}
