# kkirieat-server

## Architecture

## Requirements

- JAVA (JDK 15)
- Spring Boot
- Gradle
- Docker

## Guild Line

1. 환경 설정 <br>
   application.yaml 에서 환경 설정을 합니다.
2. Docker 실행 <br>
   Docker Compose 에는 DB(postgesql)가 세팅되어 있습니다.
    ``` 
    $ docker-compose -f environments/docker-compose.yaml up -d
    ```
3. Gradle 빌드 <br>
   Gradle을 이용해 프로젝트를 빌드하고 실행 가능한 Jar 파일을 생성합니다. Jar 파일은 /build/libs 폴더에 생성됩니다.

    ``` 
    $ chmod +x ./gradlew
    $ ./gradlew clean
    $ ./gradlew build
    $ ./gradlew bootJar
    ```
4. API Docs 확인 <br>
   Swagger 를 통해 Endpoint 를 확인합니다.<br>
   http://localhost:8080/swagger-ui.html#/
   
   
