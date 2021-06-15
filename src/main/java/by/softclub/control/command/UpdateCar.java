package by.softclub.control.command;

import by.softclub.dal.DaoFactory;
import by.softclub.servise.factory.InsCarFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/updateCar")
public class UpdateCar extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        System.out.println(request.getCookies().toString());
        System.out.println(request.getParameter("assessedValue"));
        System.out.println(request.getParameter("idd"));
        String assessedValue = request.getParameter("assessedValue");
        String name = request.getParameter("name");
        String category = request.getParameter("category");
//        if ("edit".equalsIgnoreCase(request.getParameter("action"))) {
            System.out.println("&&&&&&&&");
            DaoFactory.getInstance()
                    .getCarInsDao()
                    .update(Integer.parseInt(request.getParameter("idd")),
                            InsCarFactory.getInstance()
                                    .create(name, Integer.parseInt(assessedValue), category));
//        }

        response.sendRedirect(request.getContextPath() + "/list");


    }
}
