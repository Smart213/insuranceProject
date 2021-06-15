package by.softclub.dal.impl;

import by.softclub.dal.DaoGroupIns;
import by.softclub.entity.insuranceofperson.InsuranceOfPersonGroup;

import java.util.List;

public class DaoGroupInsImpl implements DaoGroupIns {

    @Override
    public int create(InsuranceOfPersonGroup insuranceOfPersonGroup) {
        return 0;
    }

    @Override
    public InsuranceOfPersonGroup read(String id) {
        return null;
    }

    @Override
    public void update(InsuranceOfPersonGroup insuranceOfPersonGroup, InsuranceOfPersonGroup newType) {

    }

    @Override
    public void update(Integer id, InsuranceOfPersonGroup newType) {

    }

    @Override
    public void delete(InsuranceOfPersonGroup insuranceOfPersonGroup) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<InsuranceOfPersonGroup> readAll() {
        return null;
    }
}
