package CustomInterceptor.Demo.Interceptor;

import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class MyCustomInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        System.out.println("inside Pre-Handle method");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                              HttpServletResponse response,
                              Object handler,
                           @Nullable ModelAndView modelandview) throws Exception {
        System.out.println("inside Post-Handle method");
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler,
                                   @Nullable Exception exception) throws Exception {
        System.out.println("inside After-Completion method");
    }
}
