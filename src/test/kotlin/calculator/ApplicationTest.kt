package calculator

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `입력식을 가진다`() {
        val inputExpression = InputExpression("1,2:3")
        assertThat(inputExpression.expression).isEqualTo("1,2:3")
    }

    @Test
    fun `구분자를 가진다`() {
        val spliter = Seperator("1,2:3")
        assertThat(spliter.seperator).isEqualTo(",|:")
    }

    @Test
    fun `커스텀 구분자가 존재하는지 체크`() {
        val spliter = Seperator("//;\\n1;2;3")
        assertThat(spliter.usedCustomSeperator()).isTrue()
    }

    @Test
    fun `커스텀 구분자 찾기`() {
        val spliter = Seperator("//;\\n1;2;3")
        assertThat(spliter.findSeperator()).isEqualTo(";")
    }

    @Test
    fun `구분자로 입력식 쪼개기`() {
        val inputExpression1 = InputExpression("1,2:3")
        val inputExpression2 = InputExpression("//;\\n1;2;3")
        assertThat(inputExpression1.splitExpression()).isEqualTo(listOf("1", "2", "3"))
        assertThat(inputExpression2.splitExpression()).isEqualTo(listOf("1", "2", "3"))
    }

    @Test
    fun `문자열을 숫자로 변환`() {
        assertThat(parseNumber("1")).isEqualTo(1)
    }

    @Test
    fun `문자열을 더해주는 메인 메소드`() {
        assertThat(calculate(listOf("1", "2", "3"))).isEqualTo(6)
    }

    @Test
    fun `잘못된 값을 입력할 경우 에러가 발생한다`() {
        val inputExpression1 = InputExpression("1,2, 3")
        val inputExpression2 = InputExpression(",1,2")
        val inputExpression3 = InputExpression("-1,-2,3")
        assertThrows<IllegalArgumentException> {
            inputExpression1.splitExpression()
        }
        assertThrows<IllegalArgumentException> {
            inputExpression2.splitExpression()
        }
        assertThrows<IllegalArgumentException> {
            inputExpression3.splitExpression()
        }
    }

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

    override fun runMain() {
        main()
    }
}
