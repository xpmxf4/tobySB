package tobyspring.helloboot;

import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MySpringbootApplication {
    public static void run(Class<?> applicationClass, String... args) {
        // Spring Container 생성 및 Bean 등록, 초기화
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
            @Override
            protected void onRefresh() { // Spring Container 초기화 작업
                super.onRefresh();

                // Servlet Container 생성, DispatcherServlet 초기화
                ServletWebServerFactory serverFactory = this.getBean(ServletWebServerFactory.class);
                DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);
//                dispatcherServlet.setApplicationContext(this);

                WebServer webServer = serverFactory.getWebServer(servletContext -> {
                    servletContext.addServlet("dispatcherServlet", dispatcherServlet)
                            .addMapping("/*");
                });

                webServer.start();
            }
        };
        applicationContext.register(applicationClass);
        applicationContext.refresh(); //
    }
}
