package by.softclub.servise.factory;

import by.softclub.entity.AbstractInsurance;
import by.softclub.entity.insuranceofperson.InsuranceOfPersonGroup;
import by.softclub.servise.answers.Answers;
import by.softclub.servise.interestrate.InterestRate;

import static by.softclub.entity.enums.QuestionEnum.*;

public class InsPersGroupFactory implements IAbstractFactory {

    public AbstractInsurance create() {
        InsuranceOfPersonGroup insuranceOfPersonGroup =
                InsuranceOfPersonGroup
                        .insuranceOfPersonGroup()
                        .name(new Answers().readAnswerCmd(NAME))
                        .groupSize(Integer.parseInt(new Answers().readAnswerCmd(NAME)))
                        .riskRatio(Integer.parseInt(new Answers().readAnswerCmd(NAME)))
                        .build();
        insuranceOfPersonGroup.setInterestRate(new InterestRate().rateCalculation(insuranceOfPersonGroup));
        return insuranceOfPersonGroup;
    }

    public AbstractInsurance create(String line) {
        return null;
    }
}
