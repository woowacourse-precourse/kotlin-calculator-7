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
    fun `음수 입력 시 예외 발생`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1,-2,3") }
        }
    }

    @Test
    fun `잘못된 형식의 입력 - 숫자가 아닌 값 포함`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1,a,3") }
            assertThrows<IllegalArgumentException> { runException("2,ㄱ,3") }
        }
    }

    @Test
    fun `잘못된 형식의 입력 - 실수 포함`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1,2.2,3") }

        }
    }

    @Test
    fun `잘못된 구분자 사용 시 예외 발생`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1,2;3") }
        }
    }

    @Test
    fun `잘못된 구분자 위치 - 숫자 뒤에 구분자만 존재하는 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1,2,") }
        }
    }

    @Test
    fun `잘못된 구분자 위치 - 여러 개의 구분자가 연속으로 오는 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1::3") }
        }
    }

    override fun runMain() {
        main()
    }
}
