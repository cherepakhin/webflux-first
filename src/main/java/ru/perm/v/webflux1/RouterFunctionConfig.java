package ru.perm.v.webflux1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static reactor.core.publisher.Mono.just;

@Configuration
public class RouterFunctionConfig {

	private static final Logger logger = LoggerFactory.getLogger(RouterFunctionConfig.class);

	@Autowired
	private ArticleRepository articleRepository;

	/**
	 * Простейший контроллер в реактивном стиле
	 *
	 */
	@Bean
	public RouterFunction<?> helloRouterFunction() {
		return route(GET("/hello"),
				request -> ok().body(just("Hello World!"), String.class))
				.andRoute(GET("/bye"),
						request -> ok().body(just("See ya!"), String.class));
	}
}