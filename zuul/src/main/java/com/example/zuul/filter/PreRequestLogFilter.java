package com.example.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.filters.FilterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

@Component
public class PreRequestLogFilter extends ZuulFilter {



    private static final Logger logger = LoggerFactory.getLogger(

            PreRequestLogFilter.class);

    @Override

    public Object run() {
//        FilterRegistry filterRegistry = FilterRegistry.instance();
//        filterRegistry.put();
//        FilterRegistry filterRegistry = FilterRegistry



        RequestContext context = RequestContext.getCurrentContext();

        HttpServletRequest reqeust = context.getRequest();

        PreRequestLogFilter.logger.info(

                String.format("send %srequest to %s",

                        reqeust.getMethod(),

                        reqeust.getRequestURL().toString()));

/*
        Object accessToken = reqeust.getParameter("accessToken");
        if(accessToken == null) {
            PreRequestLogFilter.logger.warn("access token is empty");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            return null;
        }*/

        return null;

    }



    @Override

    public boolean shouldFilter() {

        // 判断是否需要过滤

        return true;

    }



    @Override

    public int filterOrder() {

        // 过滤器的优先级，越大越靠后执行

        return 1;

    }



    @Override
    public String filterType() {
        // 过滤器类型
        return PRE_TYPE;
    }

}