package tobyspring.helloboot;

public class ComplexHelloService implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Complex Hello " + name;
    }
}
