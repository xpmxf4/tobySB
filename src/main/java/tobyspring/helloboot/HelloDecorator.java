package tobyspring.helloboot;

import org.springframework.stereotype.Service;

public class HelloDecorator implements HelloService {
    private final HelloService helloService;

    public HelloDecorator(HelloService helloService) {
        System.out.println("=================HelloDecorator : helloService.getClass() = " + helloService.getClass());
        this.helloService = helloService;
    }

    @Override
    public String sayHello(String name) {
        System.out.println("============================================="+"sayHello() in HelloDecorator");
        return "*" + helloService.sayHello(name) + "*";
    }
}
