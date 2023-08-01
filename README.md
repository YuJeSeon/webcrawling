<h1>BoA : 커뮤니티 베스트 게시물 웹크롤링 서비스</h1>

<blockquote>
  <p><strong>프로젝트 기간:</strong> 2023.07.23~</p>
</blockquote>

<h2> 배포주소 </h2>
> 개발 버전: https://boa.devcherio.com
<br>

<h2>프로젝트 팀원</h2>

|<div style="display: flex; align-items: flex-start;"><img src="https://avatars.githubusercontent.com/u/120304866?v=4" alt="icon" width="80" height="80" /></div>|
|:---:|
|[@YuJeSeon](https://github.com/YuJeSeon)|

<h2>시작 가이드</h2>

<h3>설치</h3>
<pre><code>$ git clone https://github.com/YuJeSeon/webcrawling.git
</code></pre>

<details>
  <summary>데이터베이스 테이블 생성 sql</summary>
  <pre><code>
  CREATE TABLE webcrawling (
    id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    type TINYINT UNSIGNED,
    title VARCHAR(255) CHARACTER SET utf8mb4,
    url VARCHAR(255) CHARACTER SET utf8mb4 UNIQUE,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
  </code></pre>
</details>

<details>
  <summary>웹 크롤링(파이썬)</summary>
  <pre><code>crawling.py에 코드추가
  <br>
  #Mysql 연결 정보
  DB_HOST = 'localhost'
  DB_USER = '{username}'
  DB_PASSWORD = '{password}'
  DB_NAME = 'webcrawling'
</code></pre>
  <h3>시작</h3>
  <pre><code>$ cd webcrawling
$ python webcrawling.py
</code></pre>
  <h3>웹크롤링 30분 매크로 설정 (ubuntu)</h3>
  <pre><code>$ cron설정 편집기 열기) crontab -e 
$ 맨아래에 추가) */30 * * * * /usr/bin/python3 /home/ubuntu/webcrawling/crawling.py
$ chmod +x /home/ubuntu/webcrawling/crawling.py
</code></pre>
</details>

<details>
  <summary>프론트엔드</summary>
  <h3>시작</h3>
  <pre><code>$ cd webcrawling/front
$ npm install
$ npm run start
</code></pre>
</details>

<details>
  <summary>백엔드</summary>
  <h3>application.yml</h3>
  <pre><code>spring:
  datasource:
    url: jdbc:mysql://localhost:3306/webcrawling?serverTimezone=Asia/Seoul
    username: {username}
    password: {password}
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    hibernate:
      ddl-auto: validate
    show-sql: true
</code></pre>
  <h3>시작</h3>
  <pre><code>$ cd webcrawling/backend
$ ./gradlew build -x test
$ cd webcrawling/backend/build/libs
$ java -jar webcrawling-0.0.1-SNAPSHOT.jar
</code></pre>
</details>

<h2>기술 스택</h2>

<h3>웹 크롤링</h3>
<p><img src="https://img.shields.io/badge/Python-3776AB?style=for-the-badge&amp;logo=python&amp;logoColor=white" alt="Python">
<img src="https://img.shields.io/badge/BeautifulSoup-fffe88?style=for-the-badge&amp;logo=beautifulsoup&amp;logoColor=black" alt="BeautifulSoup">
<img src="https://img.shields.io/badge/Requests-ff7a05?style=for-the-badge&amp;logo=requests&amp;logoColor=white" alt="Requests">
<img src="https://img.shields.io/badge/Pymysql-27A5F9?style=for-the-badge&amp;logo=pymysql&amp;logoColor=white" alt="Pymysql"></p>

<h3>백엔드</h3>
<p><img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&amp;logo=java&amp;logoColor=white" alt="Java">
<img src="https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&amp;logo=springboot&amp;logoColor=white" alt="Spring Boot">
<img src="https://img.shields.io/badge/Spring%20Data%20JPA-6DB33F?style=for-the-badge&amp;logo=spring&amp;logoColor=white" alt="Spring Data JPA">
<img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&amp;logo=mysql&amp;logoColor=white" alt="MySQL">
<img src="https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&amp;logo=gradle&amp;logoColor=white" alt="Gradle"></p>

<h3>프론트엔드</h3>
<p><img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&amp;logo=javascript&amp;logoColor=black" alt="JavaScript">
<img src="https://img.shields.io/badge/React-61DAFB?style=for-the-badge&amp;logo=react&amp;logoColor=black" alt="React">
<img src="https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&amp;logo=bootstrap&amp;logoColor=white" alt="Bootstrap">
<img src="https://img.shields.io/badge/npm-CB3837?style=for-the-badge&amp;logo=npm&amp;logoColor=white" alt="npm"></p>

<h3>기타</h3>
<p><img src="https://img.shields.io/badge/IntelliJ%20IDEA-000000?style=for-the-badge&amp;logo=intellij-idea&amp;logoColor=white" alt="IntelliJ IDEA">
<img src="https://img.shields.io/badge/VSCode-007ACC?style=for-the-badge&amp;logo=visualstudiocode&amp;logoColor=white" alt="VSCode">
<img src="https://img.shields.io/badge/Let's%20Encrypt-003A70?style=for-the-badge&amp;logo=letsencrypt&amp;logoColor=white" alt="Let's Encrypt">
<img src="https://img.shields.io/badge/nginx-269539?style=for-the-badge&amp;logo=nginx&amp;logoColor=white" alt="nginx">
<img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&amp;logo=git&amp;logoColor=white" alt="Git">
<img src="https://img.shields.io/badge/Lightsail-FF8C00?style=for-the-badge&amp;logo=amazonaws&amp;logoColor=white" alt="Lightsail">
<img src="https://img.shields.io/badge/Ubuntu-E95420?style=for-the-badge&amp;logo=ubuntu&amp;logoColor=white" alt="Ubuntu"></p>

<h2>주요 기능</h2>

<ul>
  <li>웹 크롤링: 커뮤니티 3곳(보배드림, 오늘의유머, 클리앙)에서 베스트 게시물을 30분마다 크롤링하여 저장합니다.</li>
  <li>조회 옵션: 일간, 주간, 월간, 특정 날짜 조회 등 다양한 옵션으로 조회할 수 있습니다.</li>
</ul>

## ✉️ Commit  Message
|Message|설명|
|:---:|:---|
|feat|새로운 기능 추가|
|init|프로젝트 시작, 초기화|
|update|수정 추가|
|fix|버그 수정|
|design|UI 수정|
|docs|문서 수정|
|style|코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우|
|refactor|코드 리팩토링|
|test|테스트 코드|
|chore |빌드 업무 수정, 패키지 매니저 수정|
