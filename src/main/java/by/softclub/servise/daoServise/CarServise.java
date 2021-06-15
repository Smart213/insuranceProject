package by.softclub.servise.daoServise;

import by.softclub.dal.DaoFactory;
import by.softclub.dal.impl.DaoCarInsImpl;
import by.softclub.entity.insuranceofstuff.CarInsurance;

import java.util.List;

public class CarServise {

    public List<CarInsurance> getListCarIns() {
        return new DaoCarInsImpl()
                .readAll();
    }
}
