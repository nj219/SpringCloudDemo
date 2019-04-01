package com.nj.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.nj.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author 牛杰
 * @Date 2019/3/1 15:28
 * @ClassName:WebFilter Zuul过滤器
 */
@Component
public class WebFilter extends ZuulFilter {
    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 过滤器类型
     * pre:请求目标微服务之前调用
     * route：请求目标微服务同时调用
     * error：处理请求时发生错误时被调用
     * post：在route和error过滤器之后被调用
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行顺序，数字越小 执行优先级越高
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否经过过滤器逻辑
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        //获取请求上下文
        RequestContext context = RequestContext.getCurrentContext();
        //通过上下文获取request
        HttpServletRequest request = context.getRequest();
        String requestURL = request.getRequestURL().toString();
        if (requestURL.contains("login")) {
            return false;
        }
        return true;
    }

    /**
     * 执行过滤器逻辑
     * 返回值无用途
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //获取请求上下文
        RequestContext context = RequestContext.getCurrentContext();
        //通过上下文获取request
        HttpServletRequest request = context.getRequest();
        String header = request.getHeader("Authorization");
        if (StringUtils.isNotBlank(header) && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            Claims claims = jwtUtil.parsetToken(token);
            if (claims != null) {
                return null;
            }
        }
        context.setSendZuulResponse(false);  //停止转发
        context.setResponseStatusCode(401);  //设置状态码
        context.setResponseBody("无权访问");  //设置响应体
        context.getResponse().setContentType("text/html;charset=UTF-8");

        return null;
    }
}
