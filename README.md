# spring-type-converter

### 처리과정

`@RequestParam`은 `@RequestParam`을 처리하는 `ArgumentResolver`인 `RequestParamMethodArgumentResolver` 에서 `ConversionService`를 사용해서 타입을 변환한다.  
부모 클래스와 다양한 외부 클래스를 호출하는 등 복잡한 내부 과정을 거치기 때문에 대략 적으로 이해해도 충분하다. (더 깊이 있게 알아보려면 디버그 브레이크 포인트를 통해 알아보면 된다)