package by.softclub.dal.impl;

import by.softclub.dal.DaoPersonIns;
import by.softclub.entity.insuranceofperson.InsuranceOfPersonIndividual;

import java.util.List;

public class DaoPersonInsImpl implements DaoPersonIns {

    @Override
    public int create(InsuranceOfPersonIndividual insuranceOfPersonIndividual) {
        return 0;
    }

    @Override
    public InsuranceOfPersonIndividual read(String id) {
        return null;
    }

    @Override
    public void update(InsuranceOfPersonIndividual insuranceOfPersonIndividual, InsuranceOfPersonIndividual newType) {

    }

    @Override
    public void update(Integer id, InsuranceOfPersonIndividual newType) {

    }

    @Override
    public void delete(InsuranceOfPersonIndividual insuranceOfPersonIndividual) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<InsuranceOfPersonIndividual> readAll() {
        return null;
    }
}
