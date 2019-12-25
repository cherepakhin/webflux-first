package ru.perm.v.webflux1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.perm.v.webflux1.model.Article;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterFunctionConfig {

	private static final Logger logger = LoggerFactory.getLogger(RouterFunctionConfig.class);

	@Autowired
	private ArticleRepository articleRepository;

	/**
	 * Простейший контроллер в реактивном стиле
	 */
	@Bean
	public RouterFunction routerFunction() {
		return route(GET("/articles"), this::getAllArticles)
				.andRoute(POST("/article"), this::create);
	}

	private Mono<ServerResponse> create(ServerRequest serverRequest) {
		// ТАК И НЕ СМОГ СКРЕСТИТЬ РЕАКТИВНЫЙ ЗАПРОС и НЕРЕАКТИВНЫЙ РЕПОЗИТОРИЙ
		serverRequest
				.bodyToMono(Article.class)
				.flatMap(a -> {
					logger.info("subscribe:" + a);
					return Mono.just(a);
				})
				.subscribe();
		return ServerResponse.ok().body(Mono.just(new Article(4L,"-")),Article.class);
	}

	private Mono<ServerResponse> getAllArticles(ServerRequest serverRequest) {
		logger.info("getAllArticles");
		Flux<Article> articles = Flux.fromIterable(articleRepository.findAll());
		return ServerResponse.ok().body(articles, Article.class);
	}

}