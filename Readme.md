## Эксперимент с WebFlux

Базовые типы программной модели в стиле Reactive:

- *RequestPredicate* - Объявляет вид (ы) запросов, которые будут обработаны
- *RouterFunction* - Объявляет, как соответствующий запрос должен быть направлен к коду обработчика
- *ServerRequest* - Представляет запрос HTTP, включая доступ к информации заголовка и тела
- *ServerResponse* - Представляет ответ HTTP, включая информацию заголовка и тела

Пример:
```java
package demo;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static reactor.core.publisher.Mono.just;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

@Configuration
public class RouterFunctionConfig {
   
    @Bean
    public RouterFunction<?> helloRouterFunction() {
        return route(GET("/hello"),
            request -> ok().body(just("Hello World!"), String.class));
    }
}
```

