package by.softclub.control;

import by.softclub.dal.DaoFactory;
import by.softclub.entity.insuranceofstuff.CarInsurance;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet(urlPatterns = "/list")
public class Run extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        List<CarInsurance> list = DaoFactory.getInstance().getCarInsDao().readAll();
        if (request.getAttribute("sort") != null) {
            Object sort = request.getAttribute("sort");
            if ("up".equals(sort)) {
                Collections.sort(list);
            } else if ("dn".equals(sort)) {
                Collections.sort(list);
                Collections.reverse(list);
            }
        }
        request.setAttribute("list1", list);
        request.getRequestDispatcher("/WEB-INF/jsp/list.jsp")
                .forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        switch (request.getParameter("action")) {
            case "delete":
                DaoFactory.getInstance()
                        .getCarInsDao()
                        .delete(Integer.parseInt(request.getParameter("id")));
                doGet(request, response);
                break;
            case "edit":
                request.setAttribute("idd", request.getParameter("id"));
                request.getRequestDispatcher("/WEB-INF/jsp/updateCar.jsp")
                        .forward(request, response);
                break;
            case "up":
                request.setAttribute("sort", "up");
                doGet(request, response);
                break;
            case "dn":
                request.setAttribute("sort", "dn");
            default:
                doGet(request, response);
                break;
        }
    }
}

