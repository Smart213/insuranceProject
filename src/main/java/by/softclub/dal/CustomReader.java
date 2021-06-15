package by.softclub.dal;


import by.softclub.entity.AbstractInsurance;
import by.softclub.servise.factory.IAbstractFactory;
import by.softclub.servise.factory.exception.CreateFactoryException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CustomReader {

//    public List<AbstractInsurance> read() throws IOException {
//        return readBy("src/main/resources/data/input.txt");
//    }
//
//    public List<AbstractInsurance> readBy(String path) throws CreateFactoryException, IOException {
//        List<AbstractInsurance> list = new ArrayList<>();
//        Files.lines(Paths.get(path))
//                .forEach(line -> list.add(IAbstractFactory.create(line)));
//        return list;
//    }
}
