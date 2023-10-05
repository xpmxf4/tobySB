package tobyspring.helloboot;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

public class HelloProxy implements HelloService {

    private final HelloService helloService;

    public HelloProxy(HelloService helloService) {
        System.out.println("=================HelloProxy : helloDecorator.getClass() = " + helloService.getClass());
        this.helloService = helloService;
    }

    @Override
    public String sayHello(String name) {
        // 추가적인 작업 수행
        System.out.println("=============Proxy : Before calling sayHello()==================");

        String ret = helloService.sayHello(name);

        System.out.println("=============Proxy : After calling sayHello()==================");

        return ret;
    }
}
