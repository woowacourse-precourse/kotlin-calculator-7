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

    //minus 기호가 delimiter로 사용되는 경우
    @Test
    fun `input contains minus sign custom delimiter`() {
        assertSimpleTest {
            run("//-\\n2-1,2,3")
            assertThat(output()).contains("결과: 8")
        }
    }

    override fun runMain() {
        main()
    }
}
