package tobyspring.helloboot;


import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class HellobootApplication {
    public static void main(String[] args) {
        // Spring Container 생성 및 Bean 등록, 초기화
        GenericWebApplicationContext applicationContext = new GenericWebApplicationContext();
        applicationContext.registerBean(HelloController.class);
        applicationContext.registerBean(SimpleHelloService.class);
//        applicationContext.registerBean(ComplexHelloService.class);
        applicationContext.refresh();


        // Servlet Container 생성, DispatcherServlet 초기화
        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        WebServer webServer = serverFactory.getWebServer(servletContext -> {
            servletContext.addServlet("dispatcherServlet",
                    new DispatcherServlet(applicationContext)
            ).addMapping("/*");
        });
        webServer.start();
    }
}
