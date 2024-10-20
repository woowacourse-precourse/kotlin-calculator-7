package calculator

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ExceptionTest : NsTest() {
    @Test
    fun `예외 테스트 - 잘못된 구분자`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("<<|\\n1,2,3") }
        }
    }

    @Test
    fun `예외 테스트 - 대문자를 사용한 잘못된 구분자`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("//|\\N1,2,3") }
        }
    }

    @Test
    fun `예외 테스트 - 너무 긴 잘못된 구분자`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("////|\\n1,2,3") }
        }
    }

    @Test
    fun `예외 테스트 - 마이너스 기호`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("-1,2,3") }
        }
    }

    @Test
    fun `예외 테스트 - 임의로 공백으로 구분된 입력`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("//|\\n1|2 3") }
        }
    }

    @Test
    fun `예외 테스트 - 실수의 마이너스 기호 입력`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1,-2.0,3") }
        }
    }

    @Test
    fun `예외 테스트 - 연속된 구분자`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1,2,:3") }
        }
    }

    @Test
    fun `예외 테스트 - 커스텀 구분자와 연속된 구분자`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("//|\\n1,2,|3") }
        }
    }

    @Test
    fun `예외 테스트 - 실수의 커스텀 연속된 구분자`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("//|\\n1,2.0,|3") }
        }
    }

    @Test
    fun `예외 테스트 - 구분자로 끝나는 입력`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1,2,3:") }
        }
    }

    @Test
    fun `예외 테스트 - 구분자로 시작하는 입력`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(",1,2,3") }
        }
    }

    @Test
    fun `예외 테스트 - 커스텀 구분자와 구분자로 시작하는 입력`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("//|\\n,1:1|3") }
        }
    }

    @Test
    fun `예외 테스트 - 커스텀 구분자와 구분자로 끝나는 입력`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("//|\\n1:1|3,") }
        }
    }

    @Test
    fun `예외 테스트 - 정수의 0이 포함된 값`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1,0,2,3") }
        }
    }

    @Test
    fun `예외 테스트 - 실수의 0이 포함된 값`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1,0.0,2,3") }
        }
    }

    @Test
    fun `예외 테스트 - 숫자를 커스텀 구분자로 사용시 해당 숫자를 정수 입력값으로 사용한 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("//1\\n1,1,3") }
        }
    }

    @Test
    fun `예외 테스트 - 숫자를 커스텀 구분자로 사용시 해당 숫자를 실수 입력값으로 사용한 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("//1\\n2,1.2,3") }
        }
    }

    @Test
    fun `예외 테스트 - 커스텀 구분자 선언 후 지정하지 않은 문자`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("//|\\na1|2|3") }
        }
    }

    @Test
    fun `예외 테스트 - 실수에서 소수점이 두 번 이상 등장`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("3,1.1.1,2.2") }
        }
    }

    @Test
    fun `예외 테스트 - 실수에서 소수점이 연속으로 등장`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("3,1..1,2.2") }
        }
    }

    @Test
    fun `예외 테스트 - 실수에서 소수점으로 끝나는 숫자 등장`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1.,1.1") }
        }
    }

    @Test
    fun `예외 테스트 - 실수에서 소수점이 맨 앞에 오는 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(".1,2") }
        }
    }

    @Test
    fun `예외 테스트 - 실수에서 소수점이 맨 뒤에 오는 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1,2.") }
        }
    }

    @Test
    fun `예외 테스트 - 문자열 끝에 공백이 포함된 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1,2,3 ") }
        }
    }

    @Test
    fun `예외 테스트 - 문자열 앞에 공백이 포함된 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(" 1,2,3") }
        }
    }

    @Test
    fun `예외 테스트 - 0이 2번 포함된 값`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1,00,2,3") }
        }
    }

    override fun runMain() {
        main()
    }
}
