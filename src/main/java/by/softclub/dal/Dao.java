package by.softclub.dal;

import by.softclub.entity.AbstractInsurance;

import java.util.List;

public interface Dao<Type extends AbstractInsurance> {

    int create(Type type);

    Type read(String id);

    void update(Type type, Type newType);

    void update(Integer id, Type newType);

    void delete(Type type);

    void delete(Integer id);

    List<Type> readAll();
}
