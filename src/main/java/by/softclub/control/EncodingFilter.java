package by.softclub.control;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EncodingFilter  implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        httpResponse.setCharacterEncoding("UTF-8");
        httpResponse.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
        httpResponse.setHeader("Pragma", "no-cache"); //HTTP 1.0
        httpResponse.setDateHeader("Expires", 0); //prevents caching at the proxy server

        // ANY COMMANDS

        chain.doFilter(request, response);

        // ANY COMMANDS
    }

    @Override
    public void destroy() {

    }
}
