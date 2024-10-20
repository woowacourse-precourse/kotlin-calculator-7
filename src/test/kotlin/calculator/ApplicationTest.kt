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
    fun `빈 문자열을 전달`(){
        assertSimpleTest{
            run("")
            assertThat(output()).contains("결과 : 0")
        }
    }

    @Test
    fun `문자 없일 경우와 유사`(){
        assertSimpleTest{
            run("2:::::4")
            assertThat(output()).contains("결과 : 6")
        }
    }

    @Test
    fun `하나의 정수만 전달`(){
        assertSimpleTest{
            run("123")
            assertThat(output()).contains("결과 : 123")
        }
    }


    override fun runMain() {
        main()
    }
}
