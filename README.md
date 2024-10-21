# kotlin-calculator-precourse
## 요구사항 분석
### ✏️ calculator - 초기화
* 변수 선언  
    사용자 입력을 받을 `input: String?`과 `result: Int`를 선언한다.
* 반환   
    `result`를 반환한다.
    main()에서 반환값을 받아 `결과 : ${result}` 형식으로 출력한다.

### ✏️calculator - 입력 기능
calculator()에서 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 이용하여 입력받는다.

### ✏️calculator - 설명 기능
calculator()에서 입력 받기 전, `덧셈할 문자열을 입력해 주세요.` 문구를 출력한다.

### ✏️calculator - 빈 값 처리 1
입력 값이 비어있다면 0을 반환한다.
비어있지 않다면 isRightInput()을 호출한다.

### ✏️calculator - 오류 체크 1
입력값에 `customSeparates`에 저장된 변수가 모두 있는거나 모두 없는지 확인한다.  
//만 있거나 \n만 있다면 `IllegalArgumentException`를 발생시킨다.
올바른 입력값이라면 \n의 인덱스+2 또는 0을 반환한다.

### ✏️calculator - 빈 값 처리 2
calculator()에서 반환받은 값을 `index`로 선언하고, input.size 이하라면 0을 반환한다.

### ✏️calculator - separator 호출 및 반환값 합하기
separator(index)를 호출한다.
반환된 값을 합한다.

### ✏️separator - 변수 선언
구분자 종류는 다음과 같다.
- 쉼표
- 콜론
- `//`와 `\n`사이에 위치하는 문자

따라서 변수는 다음과 같다.
- 구분자를 담은 변수 `separates: MutableList`를 선언한다. 초기값은 `,`, `:`이다.
- 커스텀 구분자를 처리하는 변수를 담은 변수 `customSeparates: List`를 선언한다. 초기값은 '//'와 '\n'이다.

### ✏️separator - 커스텀 구분자 체크
`customSeparator(index-3)`를 호출한다.  
반환 받은 값을 `separates`에 추가한다.

### ✏️customSeparator - 커스텀 구분자 구하기
인덱스 `2 ~ index`을 만나기 전까지의 문자는 커스텀 구분자이다.
두 인덱스 사이에 있는 문자들을 리스트로 반환한다.

### ✏️separator - 구분하고 반환하기
`index`부터 문자열의 끝까지를 기준으로 split()을 통해 구분한다.
오류 체크를 하고 반환한다.

### ✏️separator - 오류 체크 1
구분된 리스트가 하나라도 숫자가 아니라면 `IllegalArgumentException`을 발생시킨다.