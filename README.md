## 유효성 검사
- 사용자가 입력한 데이터가 허용된 형태인지 검사하는 과정

## 사용 가능한 어노테이션
> https://beanvalidation.org/2.0/spec/#builtinconstraints
- `@Valid` : 유효성 검사
- `@NotNull` : null이 될 수 없음
- `@NotEmpty` : 문자열,리스트 등이 비어있을 수 없음, 사이즈가 0이 아니면 ok(공백 가능)
- `@NotBlank` : 문자열이 공백이 아님, 공백으로 표현되는 문자 외의 문자가 존재함
- `@Email` : 이메일 형식인지 검사
- `@Min` : 최소값 지정 (ex. @Min(14) -> 14이상)
- `@Future` : 'YYYY-MM-DD' 형식의 날짜, 미래값만 입력 가능

## 유효성 검사 실패시 응답
- MethodArgumentNotValidException을 대상으로 예외처리
  `@ExceptionHandler(MethodArgumentNotValidException.class)`