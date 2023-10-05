package tobyspring.helloboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfig {

    @Bean
    public HelloService simpleHelloService() {
        System.out.println("=============================================" + "HelloConfig.simpleHelloService()");
        return new SimpleHelloService();
    }

    @Bean
    public HelloService helloDecorator(HelloService simpleHelloService) {
        System.out.println("=============================================HelloConfig.helloDecorator()");
        return new HelloDecorator(simpleHelloService);
    }

    @Bean
    public HelloService helloProxy(HelloService helloDecorator) {
        System.out.println("=============================================HelloConfig.helloProxy()");
        return new HelloProxy(helloDecorator);
    }
}
