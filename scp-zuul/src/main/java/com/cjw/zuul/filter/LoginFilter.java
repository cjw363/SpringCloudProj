package com.cjw.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

import org.springframework.stereotype.Component;

/**
 * @Classname LoginFilter
 * @Description
 * @Date 2020/7/7 23:06
 * @Created by cjw
 */
@Component
public class LoginFilter extends ZuulFilter {
    /**
     * 过滤器类型，前置过滤器
     * 	• pre：请求在被路由之前执行
     * 	• route：在路由请求时调用
     * 	• post：在route和errror过滤器之后调用
     *   •  error：处理请求时发生错误调用
     * @return
     *    
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     *     * 过滤器的执行顺序
     *     * @return
     *    
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     *     * 该过滤器是否生效
     *     * @return
     *    
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     *     * 登陆校验逻辑
     *     * @return
     *     * @throws ZuulException
     *    
     */
    @Override
    public Object run() throws ZuulException {
        System.out.println("LoginFilter run");
        return null;
    }
}
