package tobyspring.helloboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfig {

    @Bean
    public HelloService simpleHelloService() {
        return new SimpleHelloService();
    }

    @Bean
    public HelloService helloDecorator(HelloService simpleHelloService) {
        return new HelloDecorator(simpleHelloService);
    }

    @Bean
    public HelloService helloProxy(HelloService helloDecorator) {
        return new HelloProxy(helloDecorator);
    }
}
