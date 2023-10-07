package tobyspring.helloboot;

import org.springframework.stereotype.Service;

public class SimpleHelloService implements HelloService {
    @Override
    public String sayHello(String name) {
        System.out.println("============================================="+"sayHello() in SimpleHelloService");
        return "Hello " + name;
    }
}
