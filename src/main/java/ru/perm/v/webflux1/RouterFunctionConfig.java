package ru.perm.v.webflux1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static reactor.core.publisher.Mono.just;

@Configuration
public class RouterFunctionConfig {
	/**
	 * Простейший контроллер в реактивном стиле
	 * @return
	 */
	@Bean
	public RouterFunction<?> helloRouterFunction() {
		return route(GET("/hello"),
				request -> ok().body(just("Hello World!"), String.class));
	}
}