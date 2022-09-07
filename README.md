# Books

1. 기억을 더듬어가며 예전에 스프링을 했던 지식을 끌어내기
2. mysql을 연결할까 하다가 mysql 서버까지 하는건 힘드니까 sqlite를 쓰려고 했지만, 테스트코드도 메모리db 쓸거라 어차피 구현만 하면 되니 그냥 H2 db를 쓰기로 함
3. 1-2과정을 하면서 프로젝트 initialize만 4~5번 반복
4. implementation 'org.springframework.boot:spring-boot-starter-validation' 추가 for @NotBlank
5. dto없이 하려고 했지만 Date 변환 문제 때문에 AuthorRequestDto 추가
6. Validation 문제로 Date를 LocalDate 타입으로 변경 (레퍼런스: https://stackoverflow.com/questions/14194290/validating-a-date-in-java)
7. 6-7과정에서 LocalDate는 yyyy-MM-dd 형태의 String을 받을 수 있어 dto가 필요없어졌으므로 AuthorRequestDto 삭제. 필요할 때 추가하면 된다고 생각
8. isbn regex pattern validation (레퍼런스: https://howtodoinjava.com/java/regex/java-regex-validate-international-standard-book-number-isbns/)
9. @Size나 @Pattern 등이 @NotBlank의 역할을 수행할수도 있겠다는 생각이 들었지만 일단 추가하고 팀원의 의견을 들어보고 싶음
10. birth는 yyyy-MM-dd의 형태로 들어와야함
