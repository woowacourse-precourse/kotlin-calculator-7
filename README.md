# kotlin-calculator-precourse

## 구현할 기능
- [X] Console API를 통한 문자열 입력
- [ ] 문자열에서 숫자만 추출하기 위한 정규표현식 작성
- [ ] 입력받은 커스텀 구분자를 정규표현식에서 구분하도록 정규표현식 수정
- [ ] 정규표현식을 통해 구분자로 구분된 문자가 숫자인지 확인 후 리스트에 저장
- [ ] 추출한 숫자의 합 출력
- [ ] 예외처리
- [ ] 테스트 코드 작성

## 구현 과정
### Console API를 통한 문자열 출력
camp.nextstep.edu.missionutils.Console의 readLine()을 통해 입력을 받도록 명시되어 있다.

그렇기에 먼저 camp.nextstep.edu.missionutils.Console 라이브러리를 import한 뒤 그냥 readLine()을 통해 입력을 받으면 기본  kotlin.io의 readLine()을 사용하게 된다.

그렇기에 "Console.readLine()"을 통해 입력을 받는다.

```
package calculator
import camp.nextstep.edu.missionutils.Console
fun main() {
    val input = Console.readLine()
    println(input)
}
```

+ 실행 결과

![img.png](img.png)
