package com.springcloud.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class AccessFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

    /**
     * pre - 前置过滤器，在请求被路由前执行，通常用于处理身份认证，日志记录等；
     * route - 在路由执行后，服务调用前被调用；
     * error - 任意一个filter发生异常的时候执行或远程服务调用没有反馈的时候执行（超时），通常用于处理异常；
     * post - 在route或error执行后被调用，一般用于收集服务信息，统计服务性能指标等，也可以对response结果做特殊处理
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 同类型过滤器自然顺序执行
     * 返回值越小，执行顺序越优先
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        Object accessTocken = request.getParameter("accessTocken");
        if (accessTocken == null) {
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            return null;
        }
        return null;
    }
}
