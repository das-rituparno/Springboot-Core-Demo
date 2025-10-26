package Demo.FiltersChapter.Filter;

import jakarta.servlet.*;

import java.io.IOException;

public class MyFilter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("My-Filter -> 1 inside");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("My-Filter -> 1 inside");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
