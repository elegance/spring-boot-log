package org.orh.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@Component
public class RequestIdFilter implements Filter {
    Logger logger = LogManager.getLogger(getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String url = ((HttpServletRequest) request).getRequestURI();
        ThreadContext.put("requestId", UUID.randomUUID().toString());
        logger.info("rquestIDFilter doFilter.." + url);
        chain.doFilter(request, response);
        ThreadContext.clearAll();
    }

    @Override
    public void destroy() {

    }
}
