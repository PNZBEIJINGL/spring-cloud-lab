package com.springcloud.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
     *
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

        Object accessTocken = request.getParameter("tocken");
        if (accessTocken != null) {
            //1.测试过滤器验证，只有888888返回401
            if ("888888".equals(accessTocken)) {
                requestContext.setSendZuulResponse(false);
                requestContext.setResponseStatusCode(401);
                return null;
            }
            //2.测试直接拋出自定义异常
            if ("000000".equals(accessTocken)) {
                doSomeThing();
                return null;
            }
            //3.测试直接抛出 ZuulRuntimeException 异常
            if ("111111".equals(accessTocken)) {
                try {
                    throw new RuntimeException("In AccessFilter,Error testing,");
                } catch (Exception e) {
                    throw new ZuulRuntimeException(e);
                }
            }


            //4.测试try-catch
            if ("123456".equals(accessTocken)) {
                try {
                    throw new RuntimeException("In AccessFilter,Error testing,");
                } catch (Exception e) {
                    requestContext.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    requestContext.setThrowable(e);
                }
                return null;
            }


            return null;
        }
        return null;
    }

    private void doSomeThing() {
        log.error("AccessFilter error");
        throw new RuntimeException("In AccessFilter,Error testing,");
    }


}
