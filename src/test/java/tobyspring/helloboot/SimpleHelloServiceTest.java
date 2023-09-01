package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleHelloServiceTest {
    @Test
    void simpleHelloService () {
        SimpleHelloService helloService = new SimpleHelloService();

        String ret = helloService.sayHello("spring");

        Assertions.assertThat(ret).isEqualTo("Hello spring");
    }
}
