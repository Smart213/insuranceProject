package by.softclub.servise.interestrate;

import by.softclub.entity.insuranceofperson.InsuranceOfPersonGroup;
import by.softclub.entity.insuranceofperson.InsuranceOfPersonIndividual;
import by.softclub.entity.insuranceofstuff.CarInsurance;

public class InterestRate {

    public Integer rateCalculation(InsuranceOfPersonGroup entity) {
        return (entity.getRiskRatio() - 50 / entity.getGroupSize() + entity.getGroupSize());
    }

    public Integer rateCalculation(InsuranceOfPersonIndividual entity) {
        return (entity.getDiscount() - 5 * entity.getDiscount());
    }

    public Integer rateCalculation(CarInsurance entity) {
        return (int) ((Math.random() * 6) + 1) * entity.getCategory().toCharArray()[0];
    }
}
