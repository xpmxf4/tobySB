package tobyspring.helloboot;


import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HellobootApplication {
    public static void main(String[] args) {
        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        WebServer webServer = serverFactory.getWebServer(servletContext -> {
            HelloController helloController = new HelloController();
            servletContext.addServlet("FrontController", new HttpServlet() {
                @Override
                // 여기서 요청, 응답 조작
                protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                    if (req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())) {
                        // request
                        String name = req.getParameter("name");
                        String ret = helloController.hello(name);

                        // response
                        resp.setStatus(HttpStatus.OK.value());
                        resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
                        resp.addHeader("Custom-Header", "Custom");
                        resp.getWriter().println(ret);
                    } else if (req.getRequestURI().equals("users")) {
                        resp.getWriter().println("this is users block");
                    } else if (req.getRequestURI().equals("security")) {
                        resp.getWriter().println("this is security block");
                    } else {
                        resp.setStatus(HttpStatus.NO_CONTENT.value());
                    }
                }
            }).addMapping("/*");


        });
        webServer.start();
    }
}
