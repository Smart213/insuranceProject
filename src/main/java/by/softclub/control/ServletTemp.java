package by.softclub.control;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletTemp", urlPatterns = "/temp" )
public class ServletTemp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>!!!Hello World!!! TEMP</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
/**
 *package controller;
 *
 * import java.io.IOException;
 *
 * import javax.servlet.Filter;
 * import javax.servlet.FilterChain;
 * import javax.servlet.FilterConfig;
 * import javax.servlet.ServletException;
 * import javax.servlet.ServletRequest;
 * import javax.servlet.ServletResponse;
 * import javax.servlet.http.HttpServletResponse;
 *
 * public class EncodingFilter implements Filter {
 *        @Override
 *    public void init(FilterConfig filterConfig) throws ServletException {}
 *
 *    @Override
 *    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
 * 		request.setCharacterEncoding("UTF-8");
 * 		HttpServletResponse httpResponse = (HttpServletResponse)response;
 * 		httpResponse.setCharacterEncoding("UTF-8");
 * 		httpResponse.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
 * 		httpResponse.setHeader("Pragma", "no-cache"); //HTTP 1.0
 * 		httpResponse.setDateHeader("Expires", 0); //prevents caching at the proxy server
 *
 *
 * 		chain.doFilter(request, response);
 *
 * 		// ANY COMMANDS
 *    }
 *
 *    @Override
 *    public void destroy() {}
 * }
 */