package by.softclub.dal.impl;

import by.softclub.dal.DaoCarInsurance;
import by.softclub.dal.Postgre;
import by.softclub.entity.insuranceofstuff.CarInsurance;
import by.softclub.servise.factory.InsCarFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoCarInsImpl implements DaoCarInsurance {
    //    static final org.apache.log4j.Logger logger = Logger.getLogger(DaoCarInsImpl.class);
    Postgre postgre = new Postgre();

    private final String SQL_CAR_INSERT =
            "INSERT into public.\"LearningDB\"(id, name, as_value, category, interest_rate) VALUES (?, ?, ?, ?, ?);";
    private final String SQL_CAR_UPDATE =
            "UPDATE public.\"LearningDB\" SET  name=?, as_value=?, category=?, interest_rate=? WHERE id=?;";
    private final String SQL_GET_ALL_CAR = "SELECT * FROM public.\"LearningDB\" ";
    private final String SQL_DEL = "DELETE FROM public.\"LearningDB\" WHERE id=?;";


    @Override
    public int create(CarInsurance carInsurance) {
        try {
            Connection cn = postgre.connect();
            PreparedStatement preparedStatement =
                    cn.prepareStatement(SQL_CAR_INSERT);
            preparedStatement.setInt(1, postgre.getCount() + 1);//TODO переделать ID
            preparedStatement.setString(2, carInsurance.getName());
            preparedStatement.setInt(3, carInsurance.getAssessedValue());
            preparedStatement.setString(4, carInsurance.getCategory());
            preparedStatement.setInt(5, carInsurance.getInterestRate());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                rs.getInt(1);
//                logger.debug(key);
                carInsurance.setId(postgre.getCount() + 1);
            }
            cn.commit();
            cn.close();
            return 1;
        } catch (SQLException throwables) {
//            logger.error(throwables);
            System.out.println(throwables);
            return 0;
        }
    }

    @Override
    public CarInsurance read(String id) {
        return null;
    }

    @Override
    public void update(CarInsurance carInsurance, CarInsurance newType) {
        update(carInsurance.getId(), newType);
    }

    @Override
    public void update(Integer id, CarInsurance newType) {
        try {
            Connection cn = postgre.connect();
            PreparedStatement preparedStatement =
                    cn.prepareStatement(SQL_CAR_UPDATE);
            preparedStatement.setString(1, newType.getName());
            preparedStatement.setInt(2, newType.getAssessedValue());
            preparedStatement.setString(3, newType.getCategory());
            preparedStatement.setInt(4, newType.getInterestRate());
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
            cn.commit();
            cn.close();
        } catch (SQLException throwables) {
//            logger.error(throwables);
            System.out.println(throwables.getMessage());
        }
    }

    @Override
    public void delete(CarInsurance carInsurance) {
        delete(carInsurance.getId());
    }


    @Override
    public void delete(Integer id) {
        try {
            Connection cn = postgre.connect();
            PreparedStatement preparedStatement =
                    cn.prepareStatement(SQL_DEL);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            cn.commit();
            System.out.println("удален " + id);
            cn.close();
        } catch (SQLException e) {
//            logger.error(e);
        }
    }

    @Override
    public List<CarInsurance> readAll() {
        try {
            Statement st =
                    postgre.connect()
                            .createStatement();
            ResultSet resultSet = st.executeQuery(SQL_GET_ALL_CAR);
            List<CarInsurance> carInsuranceList = new ArrayList<>();
            while (resultSet.next()) {
                carInsuranceList.add(InsCarFactory.getInstance().create(resultSet));
            }
            return carInsuranceList;
        } catch (Exception throwables) {
//            logger.error(throwables);
            throwables.printStackTrace();
            return new ArrayList<>();
        }
    }
}
