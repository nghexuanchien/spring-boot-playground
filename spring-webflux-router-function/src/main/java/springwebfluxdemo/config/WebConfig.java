package springwebfluxdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import springwebfluxdemo.model.Student;
import springwebfluxdemo.service.DemoService;
import springwebfluxdemo.util.Utils;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;

/**
 * @author chiennghe
 */

@Configuration
public class WebConfig {

    @Bean
    RouterFunction<?> routes (DemoService demoService){
        return RouterFunctions
                .route(GET("/home"),
                        serverRequest -> ServerResponse.ok().contentType(MediaType.TEXT_HTML)
                        .render("index", demoService.home()))

                .andRoute(POST("/submitStudentInfo"),
                        serverRequest -> ServerResponse.ok().contentType(MediaType.TEXT_HTML)
                        .render("index", demoService.submitStudentInfo(
                                Utils.convertMapToObject(serverRequest.body(BodyExtractors.toFormData()).block().toSingleValueMap(), Student.class)
                        )));
    }
}
