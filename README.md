# kkirieat-server

##Architecture
TODO

##Requirements
- JAVA (JDK 15)
- Spring Boot
- Gradle
- Docker

##Step
1. 환경 설정 <br>
kkiri-eat 사용을 위해 application.yaml에서 환경 설정을 합니다.
2. Docker Compose 실행 <br>
제공되는 도커 컴포즈에는 DB(postgesql)가 세팅되어 있습니다.
    ``` 
    $ docker-compose -f environments/docker-compose.yaml up -d
    ```
3. 빌드 <br>
Gradle을 이용해 프로젝트를 빌드하고 실행 가능한 Jar 파일을 생성합니다. Jar 파일은 /build/libs 폴더에 생성됩니다.

    ``` 
    $ chmod +x ./gradlew
    $ ./gradlew clean
    $ ./gradlew build
    $ ./gradlew bootJar
    ```