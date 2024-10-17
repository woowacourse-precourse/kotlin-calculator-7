# kotlin-calculator-precourse
## ✏️ 기능 목록
### 주요 기능
- 입력
  - [x] 문자열 입력
- 출력 
  - [x] Prefix 문구 출력
  - [ ] 결과 출력
- 계산
  - [ ] 숫자를 더한다
- Parse
  - [ ] 구분자 등록 부 분리
  - [ ] 숫자부 분리
- 검증
  - [x] 전체 형식 검증
  - [ ] 양수 검증

## 🚧 트러블 슈팅
- ### UnsupportedClassVersionError
  ```
  기본 클래스 calculator.ApplicationKt을(를) 로드하는 중 LinkageError가 발생했습니다.
  java.lang.UnsupportedClassVersionError: calculator/ApplicationKt has been compiled by a more recent version of the Java Runtime (class file version 65.0), this version of the Java Runtime only recognizes class file versions up to 55.0`
  ``` 
  - 원인: 프로젝트의 버전과 실행 시 JDK 버전이 달라서 생기는 문제 
  - 해결방법: file -> project structure -> sdk를 buld.gradle 파일에 명시된 버전으로 변경한다.