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
            assertThat(output()).contains("결과 : 1")
        }
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("-1,2,3") }
        }
    }

    @Test
    fun testNoInput()
    {
        assertSimpleTest {
            run("")
            assertThat(output()).contains("결과 : 0")
        }
    }

    @Test
    fun testOneInput()
    {
        assertSimpleTest {
            run("3")
            assertThat(output()).contains("결과 : 3")
        }
    }

    @Test
    fun testCommaInput()
    {
        assertSimpleTest {
            run("1,2,3")
            assertThat(output()).contains("결과 : 6")
        }
    }

    @Test
    fun testColonInput()
    {
        assertSimpleTest {
            run("1:2:3")
            assertThat(output()).contains("결과 : 6")
        }
    }

    @Test
    fun testCommaColonInput()
    {
        assertSimpleTest {
            run("1,2:3")
            assertThat(output()).contains("결과 : 6")
        }
    }

    override fun runMain() {
        main()
    }
}
