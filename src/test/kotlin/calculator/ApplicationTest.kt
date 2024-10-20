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
    fun `중복 구분자 테스트`() {
        assertSimpleTest {
            run("///*---\\n32,1:2*9/56-7")
            assertThat(output()).contains("결과 : 107")
        }
    }

    @Test
    fun `구분자로 backslash 사용 테스트`() {
        assertSimpleTest {
            run("///\\*-\\n32,1:2*9/56-7\\30")
            assertThat(output()).contains("결과 : 137")
        }
    }

    @Test
    fun `구분자로 숫자 사용 테스트`() {
        assertSimpleTest {
            run("///\\*46-\\n32,1:2*9/565-7\\30")
            assertThat(output()).contains("결과 : 91")
        }
    }

    @Test
    fun `커스텀 구분자 입력에 줄바꿈이 없는 경우에 대한 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("///\\*-32,1:2*9/56-7\\30") }
        }
    }

    @Test
    fun `매우 큰 수에 대한 입력`() {
        assertSimpleTest {
            run("123456789123456789123456789123456789,123456789123456789123456789123456789")
            assertThat(output()).contains("결과 : 246913578246913578246913578246913578")
        }
    }

    @Test
    fun `커스텀 구분자 입력에 개행문자가 중복으로 존재`() {
        assertSimpleTest {
            run("//*\\n&\\n1\\2n3")
            assertThat(output()).contains("결과 : 6")
        }
    }

    override fun runMain() {
        main()
    }
}
