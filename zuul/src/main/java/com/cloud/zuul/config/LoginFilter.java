package com.cloud.zuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Auther: cuibaoluo
 * @Date: 2019/5/31 16:15
 * @Description:
 */
@Component
public class LoginFilter extends ZuulFilter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        logger.info("{} >>> {}", request.getMethod(), request.getRequestURI().toString());
        String token = request.getParameter("token");
        if (token == null) {
            logger.error("Error! Request Token is Empty");
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            try {
                currentContext.getResponse().getWriter().write("Request token is empty");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
