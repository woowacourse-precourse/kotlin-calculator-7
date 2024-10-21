package calculator

import calculator.Runner.Companion.RESULT_MESSAGE
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RunnerTest : NsTest() {
    private lateinit var runner: Runner

    @BeforeEach
    fun setup() {
        runner = Runner()
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "1,2:3\t6",
            ":1:2:3\t6",
            "1:2:3:\t6",
            ":\t0",
            ",:\t0"
        ]
    )
    fun `실행 성공 - 기본 구분자`(source: String) {
        val (input, result) = source.split("\t")

        run(input)
        runner.run()

        assertThat(output()).contains("$RESULT_MESSAGE$result")
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "//-\\n1-2-3\t6",
            "//-\\n1-2:3,4\t10",
            "//-\\n-1-2-3-\t6",
            "//~\\n,:~\t0",
            "//1\\n2122110\t24",
            "//1\\n21221,10:20\t44"
        ]
    )
    fun `실행 성공 - 커스텀 구분자`(source: String) {
        val (input, result) = source.split("\t")

        run(input)
        runner.run()

        assertThat(output()).contains("$RESULT_MESSAGE$result")
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "1-2-3",
            "//v\\n1v2,2:3-",
            "-",
            ":-,"
        ]
    )
    fun `실행 실패 - 존재하지 않는 커스텀 문자 포함`(input: String) {
        run(input)

        assertThrows<IllegalArgumentException> {
            runner.run()
        }
    }

    @Test
    fun `실행 실패 - 너무 큰 값`() {
        run("${Long.MAX_VALUE - 10}:4:6,1")

        assertThrows<IllegalArgumentException> {
            runner.run()
        }
    }

    override fun runMain() {
    }
}
