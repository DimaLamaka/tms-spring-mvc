package by.lamaka.springmvc.interceptors;


import lombok.extern.log4j.Log4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;


@Log4j
public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        StringBuilder msg = new StringBuilder("User has moved to the path : " + request.getRequestURI() +
                "\n");
        Enumeration<String> parameterNames = request.getParameterNames();

        if (parameterNames.hasMoreElements()) {
            msg.append("User has sent data: \n");
        }
        while (parameterNames.hasMoreElements()) {
            String nextParameter = parameterNames.nextElement();
            msg.append(nextParameter).append(" : ").append(request.getParameter(nextParameter)).append("\n");
        }

        log.info(msg);
        return true;
    }
}
