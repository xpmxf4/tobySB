package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloControllerTest {
    @Test
    void helloControllerTest() {
        HelloController helloController = new HelloController(name -> name);

        String ret = helloController.hello("Spring");

        Assertions.assertThat(ret).isEqualTo("Spring");
    }

    @Test
    void failedHelloControllerTest() {
        HelloController helloController = new HelloController(name -> name);

        Assertions.assertThatThrownBy(() -> {
            String ret = helloController.hello(null);
        }).isInstanceOf(IllegalStateException.class);

        Assertions.assertThatThrownBy(() -> {
            String ret = helloController.hello("");
        }).isInstanceOf(IllegalStateException.class);


    }
}
