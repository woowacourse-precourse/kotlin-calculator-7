# kotlin-calculator-precourse

## 구현할 기능
- [X] Console API를 통한 문자열 입력
- [X] 문자열에서 숫자만 추출하기 위한 정규표현식 작성
- [X] 정규표현식을 통해 구분자로 구분된 숫자들의 합 도출
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

### 문자열에서 숫자만 추출하기 위한 정규표현식 작성
+ 정규표현식을 작성하던 중 기존에 커스텀 기능을 기본 구분자를 구분하는 정규표현식을 작성 후 추가하려 했으나 한번에 진행하는 것이 보다 용이할 것으로 판단하여 구현할 기능 수정

```
val customDelimiterPattern = """//(.)\n(.*)""".toRegex()
```
처음에는 단순히 문자열을 입력받고 처음 5개의 문자를 확인한 후 커스텀 구분자가 있는 지 없는 지를 확인하려 하였으나
이번 기회에 정규표현식을 다시 한번 복기해보고자 정규표현식으로 구분하기로 하였다.

처음에 //(.)\n로 //와 \n 사이의 단일 문자를 캡처해서 한 그룹

이후의 문자를 전부 두번째 그룹을 묶는다.

### 합 도출
+ 처음에는 값을 list에 저장하고 이후 sum을 통한 값을 return하려 하였으나 불필요하게 코드가 길어진다고 판단하여 구현할 기능 목록을 수정하였다.


입력은 커스텀 구분자가 있거나 없는 경우의 수가 2가지 존재한다.
+ input에 정규표현식을 적용하여 커스텀구분자를 구하고 첫 번째 그룹은 구분자, 두 번째 그룹은 이후 전체 문자열

+ 만약 커스텀구분자가 없다면 input 을 바로 사용  

그렇기에 각각을 구분하여 spilt()을 사용하고 나눠진 문자를 정수로 변환한 뒤 합을 구하고 그것을 return한다.