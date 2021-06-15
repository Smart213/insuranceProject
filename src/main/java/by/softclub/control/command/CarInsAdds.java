package by.softclub.control.command;

import by.softclub.dal.DaoFactory;
import by.softclub.entity.insuranceofstuff.CarInsurance;
import by.softclub.servise.factory.InsCarFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/newcaradd1")
public class CarInsAdds extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        System.out.println("_______вошли");
        request.getRequestDispatcher("/WEB-INF/jsp/addCarIns.jsp")
                .forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String assessedValue = request.getParameter("assessedValue");
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        CarInsurance car = InsCarFactory.getInstance()
                .create(name, Integer.parseInt(assessedValue), category);
        System.out.println(car.toString());

        int added =
                DaoFactory.getInstance()
                        .getCarInsDao()
                        .create(car);
        System.out.println(added);

        List<CarInsurance> listAdd = new ArrayList<>();
        listAdd.add(car);
        request.setAttribute("added", added);
        request.setAttribute("list2", listAdd);
        System.out.println("_______вышли");
        doGet(request, response);//TODO редирект
    }
}

