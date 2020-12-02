# Intro.

PoC로 후딱 만들다 보니 생긴 문제점을 제거하고 넘어가보자.  

# 1. 리팩토링 & 기능 추가

- RootHandler(refactoring)
- EmbeddedServerConfiguration(refactoring)
- Middlewares(refactoring)
- HandlerKey(new feature)

## 1.1. RootHandler

문제점

1. 톰캣에 종속적임 -> 추상클래스나 인터페이스로 분리 필요 (스프링의 DispatcherServlet을 생각해보자)
2. 리소스가 없는 경우(not found)나 서버 에러(Internal server error)에 대한 처리 방식 지정 필요 -> 다형성
3. 스태틱 파일 서빙 방식 고민 -> 다형성으로 처리해야하는데 현재는 분기 중

문제점까진 아니고 고민

1. 현재 `Context`에서 렌더링을 하고 있는데 뷰를 선택할 책임이 이곳에 있어야 하는지 고민 필요
2. 미들웨어 실행하는 방식이 전혀 마음에 안들어..

## 1.2. EmbeddedServerConfiguration

문제점까진 아니고 고민

1. 인터페이스로 뺄까..? 안티패턴일까..?

## 1.3. Middlewares

문제점

1. getter 빼자.  
2. 미들웨어 실행에 대한 의무는 `Middlewares`에게 있어야 함

## 1.4. HandlerKey

기능

1. PathVariable 지원하도록 수정 필요. HandlerMapping 강화 필요.

# 2. 뜬금없는데 미래에 지원할거 고민해보자

1. reactive 지원
2. repository 관련 규격(인터페이스) 고민
3. 의존성 관리 지원(flask나 django 생각해보자)