# Intro.

Lightweight Micro Web Framework.

## Getting Started

다음과 같이 서비스를 시작할 수 있다.

```java
public class Application {

    public static void main(String[] args) {
        Garam.get("/", ctx -> ctx.render("index", new GaramModel()));
        Garam.get("/v1/data", ctx ->
                ctx.response()
                        .status(HttpStatus.OK)
                        .contentType("application/json")
                        .text("{\"message\": \"Garam Framework.\"}"));
        Garam.port(1234);
        Garam.run();
    }
}
```

## 1. Environment & Configuration

환경은 다음과 같이 구분한다.

1. default: .env
2. whatever_you_want: .env-whatever_you_want
    - ex) .env-production
    
설정은 `key-value pair`로 구성되어 있으며 구분자(delimiter)는 `=`이다. `key`는 `case-insensitive`이다.  
예제 파일은 다음과 같다.

```text
SERVICE_PORT=1234
database_url=jdbc:h2:mem:1dfd3cb3-5f2f-4fd0-ad19-68ad8addbdef
```

환경파일 스캔 순서 우선순위는 다음과 같다.  

1. JVM argument: `-DenvFilePath=/path/to/config/filename`
2. classpath: ex) src/main/resources/.env

환경은 다음과 같이 지정할 수 있다.

1. JVM argument: `-Denv=production`