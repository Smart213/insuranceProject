package by.softclub.dal;

import by.softclub.dal.impl.DaoCarInsImpl;
import by.softclub.dal.impl.DaoGroupInsImpl;
import by.softclub.dal.impl.DaoPersonInsImpl;


public class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();

    private final DaoCarInsurance carInsDao = new DaoCarInsImpl();
    private final DaoPersonIns personalInsDao = new DaoPersonInsImpl();
    private final DaoGroupIns groupInsDao = new DaoGroupInsImpl();

    public DaoFactory() {
    }

    public DaoCarInsurance getCarInsDao() {
        return carInsDao;
    }

    public DaoPersonIns getPersonalInsDao() {
        return personalInsDao;
    }

    public DaoGroupIns getGroupInsDao() {
        return groupInsDao;
    }

    public static DaoFactory getInstance() {
        return instance;
    }
}
