package tobyspring.helloboot;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class HelloController {
    private final HelloService helloService;
//    private final ApplicationContext applicationContext;

//    public HelloController(HelloService helloService, ApplicationContext applicationContext) {
//        this.helloService = helloService;
//        this.applicationContext = applicationContext;
//
//        System.out.println("==========================="+applicationContext);
//    }

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    // GET + URL : /hello
    @GetMapping("/hello")
//    @ResponseBody // 이거 없으면 Return String 이 view 의 이름을 반환하는 걸로 Dispatcher Servlet 이 이해함.
//    중요한 건, 각각의 애너테이션에 따라 생략이 되더라도, 해당 정보가 필요하다는 것을 기억하자!!
//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(String name) {
//        return helloService.sayHello(Objects.requireNonNull(name));
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException();
        }

        return helloService.sayHello(name);
    }
}