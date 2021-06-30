package ru.rest.restfultemplate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import ru.rest.restfultemplate.service.Quote;


@SpringBootApplication
@Slf4j
public class RestFulTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestFulTemplateApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner runner(RestTemplate restTemplate) {
        return args -> {
            Quote quote = restTemplate.getForObject("https://quoters.apps.pcfone.io/api/random", Quote.class);
            assert quote != null;
            log.info(quote.toString());
        };
    }
}
