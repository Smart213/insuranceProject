package by.softclub.control;

import by.softclub.dal.impl.DaoCarInsImpl;

public class Generate {

    public static void main(String[] args) {

        new DaoCarInsImpl()
                .delete(1);

    }
}
