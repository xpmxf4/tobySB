package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloApiTest {
    @Test
    void helloApi() {
        TestRestTemplate restTemplate = new TestRestTemplate();

        ResponseEntity<String> res =
                restTemplate.getForEntity("http://localhost:8080/hello?name={name}", String.class, "Spring Boot");

        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(res.getHeaders().getFirst("Content-Type")).startsWith(MediaType.TEXT_PLAIN_VALUE);
        assertThat(res.getBody()).isEqualTo("Hello Spring Boot");
    }

    @Test
    void helloFailApi() {
        TestRestTemplate restTemplate = new TestRestTemplate();

        ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:8080/hello?name=", String.class);

        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
