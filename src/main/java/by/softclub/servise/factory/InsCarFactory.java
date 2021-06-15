package by.softclub.servise.factory;


import by.softclub.dal.DaoCarInsurance;
import by.softclub.dal.DaoFactory;
import by.softclub.entity.AbstractInsurance;
import by.softclub.entity.insuranceofstuff.CarInsurance;
import by.softclub.servise.answers.Answers;
import by.softclub.servise.factory.exception.CreateFactoryException;
import by.softclub.servise.interestrate.InterestRate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static by.softclub.entity.enums.QuestionEnum.*;
import static by.softclub.servise.parseutil.ParseUtil.*;

public class InsCarFactory implements IAbstractFactory {

    public static InsCarFactory isnt = new InsCarFactory();

    public static InsCarFactory getInstance() {
        return isnt;
    }

    public CarInsurance create() throws CreateFactoryException {
        CarInsurance carInsurance
                = CarInsurance.carBuilder()
                .name(new Answers().readAnswerCmd(NAME))
                .assessedValue(Integer.parseInt(new Answers().readAnswerCmd(ASSESSED_VALUE)))
                .category((new Answers().readAnswerCmd(CATEGORY)))
                .build();
        carInsurance.setInterestRate(new InterestRate().rateCalculation(carInsurance));
        return carInsurance;
    }

    public CarInsurance create(String name, int asVal, String category) throws CreateFactoryException {
        CarInsurance carInsurance
                = CarInsurance.carBuilder()
                .assessedValue(asVal)
                .category(category)
                .name(name)
                .build();
        carInsurance.setInterestRate(new InterestRate().rateCalculation(carInsurance));
        return carInsurance;
    }

    public CarInsurance create(ResultSet resultSet) throws CreateFactoryException, SQLException {
        return CarInsurance.carBuilder()
                .id(resultSet.getInt("id"))
                .assessedValue(resultSet.getInt("as_value"))
                .category(resultSet.getString("category"))
                .name(resultSet.getString("name"))
                .interestRate(resultSet.getInt("interest_rate"))
                .build();
    }

    public CarInsurance generate() throws CreateFactoryException {
        int unique = Integer.parseInt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("ssSSS")));
        CarInsurance carInsurance
                = CarInsurance.carBuilder()
                .name("sdfghj" + unique)
                .assessedValue(unique)
                .category("c")
                .build();
        carInsurance.setInterestRate(new InterestRate().rateCalculation(carInsurance));
        return carInsurance;
    }

    public AbstractInsurance create(String line) throws CreateFactoryException {
        List<String> args = Arrays.asList(line.split("\\$"));
        if (args.size() == 4) {
            CarInsurance carInsurance =
                    CarInsurance.carBuilder()
                            .category(parseByTagChar(args, CATEGORY))
                            .assessedValue(parseByTagInt(args, ASSESSED_VALUE))
                            .id(Integer.parseInt(parseByTagSting(args, ID)))
                            .name(parseByTagSting(args, NAME))
                            .build();
            carInsurance.setInterestRate(new InterestRate().rateCalculation(carInsurance));
            DaoCarInsurance carInsDao =
                    DaoFactory.getInstance().getCarInsDao();
            carInsDao.create(carInsurance);
            return carInsurance;
        } else throw new CreateFactoryException("Недостаточно данных для создания объекта: " + line);
    }

}
