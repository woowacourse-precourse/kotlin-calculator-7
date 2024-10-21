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
    fun `숫자만 입력했을 때는 입력한 숫자 그대로 반환한다`() {
        assertSimpleTest {
            run("1234")
            assertThat(output()).contains("결과 : 1234")
        }
    }

    @Test
    fun `숫자 없이 구분자만 입력할 경우 IllegalArgumentException 을 발생시킨다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(",,:") }
        }
    }

    @Test
    fun `공백만 입력할 경우 IllegalArgumentException 을 발생시킨다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("    ") }
        }
    }

    @Test
    fun `기본 구분자로 시작할 경우 IllegalArgumentException 을 발생시킨다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(",2:3") }
        }
    }

    @Test
    fun `기본 구분자로 끝날 경우 IllegalArgumentException 을 발생시킨다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("2:3,") }
        }
    }

    @Test
    fun `커스텀 구분자로 끝날 경우 IllegalArgumentException 을 발생시킨다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("//#\n2#") }
        }
    }

    @Test
    fun `알 수 없는 문자열(기본 구분자 및 커스텀 구분자가 아닐 때)을 사용할 경우 IllegalArgumentException 을 발생시킨다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("//n\n3#4") }
        }
    }

    @Test
    fun `기본 구분자와 커스텀 구분자를 섞어 사용할 경우 문자열 덧셈 계산기는 작동한다`() {
        assertSimpleTest {
            run("//$\\n3$4:5")
            assertThat(output()).contains("결과 : 12")
        }
    }

    @Test
    fun `커스텀 구분자를 공백으로 선언할 경우 IllegalArgumentException 을 발생시킨다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("// \\n3 4") }
        }
    }

    @Test
    fun `커스텀 구분자를 숫자로 선언할 경우 IllegalArgumentException 을 발생시킨다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("//2\\n324") }
        }
    }

    @Test
    fun `커스텀 구분자를 -(dash)로 선언할 경우 IllegalArgumentException 을 발생시킨다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("//-\\n3-2-4") }
        }
    }

    override fun runMain() {
        main()
    }
}
