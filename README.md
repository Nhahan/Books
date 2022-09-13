# Books
<br>

## 1. 아키텍쳐, ci/cd 파이프라인
<img width="729" alt="image" src="https://user-images.githubusercontent.com/81916648/189662379-75087303-66c4-468b-8da7-5bb44ac9e8d7.png">

- 배포 프로세스 상태 확인하는 법
<img width="311" alt="image" src="https://user-images.githubusercontent.com/81916648/189677990-2f0b3fde-e015-4842-983f-a49e0a97012a.png">
✅ Green: 성공 / 🟡 Yello: 진행중 / ❌ Red: 실패 혹은 취소 
<br>
<br>

## 2. 스웨거
http://books3.ap-northeast-2.elasticbeanstalk.com/swagger-ui/#/

<br>

## 3. 설명

- mysql을 쓸까 하다가 무리하고 싶지 않아서 sqlite를 쓰려고 했지만, 간단한 테스트코드도 메모리DB 쓸 생각이었기 때문에 그냥 H2를 쓰기로 했습니다.
- dto를 최대한 없이 하려다가 Book은 필요해서 넣었고, Author는 없어도 됐지만 Swagger에 깔끔하게 나오는게 좋아서 결국 dto를 다 넣었습니다.
- 이 프로젝트의 최대 고민은 Book과 Author의 다대다 관계 설정이었습니다. 간단하게 할건데 양방향으로 할 시 FK관리와 create할 때 힘드니까 AuthorBook 중간테이블에서만 @ManyToOne으로 하기로 했습니다. 따라서 Book의 입장에서는 AuthorBook의 존재를 모르니 BookService getBooks()에서 쿼리를 두 번 했습니다.
- 따로 누군가에게 질문할 필요 없이 Swagger만 봐도 모든 API를 직관적으로 알 수 있게 description을 작성해보았습니다.
- Paging은 스프링에서 Page/Slice/List로 할 수 있는데 개인적으로 count쿼리가 나가지 않고 페이징시  Slice로 하는게 가장 맞다고 생각하지만, 따로 주문사항이 없었고 Book타입을 조작해서 BookResponseDto를 만들어줘야했기 때문에 구현하기 쉬운 List로 했습니다.
- 로직 자체가 create와 read밖에 없기 때문에 테스트코드는 실제 DB에 create와 read가 되는지 정도의 코드만 작성했습니다.
<br>

## 4. 배포 방법
- master 브랜치에 코드 푸시하면 자동 배포
<br>

## 5. 로컬 빌드 방법
 🛠 환경: Java 11, Gradle
- 최상위 디렉토리인 /Books에서 `./gradlew build && java -jar ./build/libs/books-0.0.1-SNAPSHOT.jar`
- Port 문제로 안될 시 /src/main/resources/application.properties에서 `server.port=5000` 포트 숫자 변경 후 실행
<br>

<hr>

#### 레퍼런스
- LocalDate가 더 좋아보여서 Date를 LocalDate 타입으로 변경 (레퍼런스: https://stackoverflow.com/questions/14194290/validating-a-date-in-java)
- isbn regex pattern validation (레퍼런스: https://howtodoinjava.com/java/regex/java-regex-validate-international-standard-book-number-isbns/)
