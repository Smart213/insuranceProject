package by.softclub.servise.factory;

import by.softclub.entity.AbstractInsurance;
import by.softclub.servise.answers.Answers;
import by.softclub.servise.factory.exception.CreateFactoryException;

import java.util.Arrays;

import static by.softclub.entity.enums.QuestionEnum.CHOICE_TYPE;

public interface IAbstractFactory {

default     AbstractInsurance create(){
    return null;
};

default     AbstractInsurance create(String line){return null;};

//    static AbstractInsurance create(String line) throws CreateFactoryException {
//        int type = Integer.parseInt(
//                String.valueOf(Arrays.stream(line.split("\\$"))
//                        .filter(s -> s.contains("id:"))
//                        .findFirst()
//                        .orElseThrow(() -> new CreateFactoryException("Не удалось создать объект из строки:\n" + line))
//                        .split(":")[1]
//                        .toCharArray()[0]));
//        switch (type) {
//            case 1:
//                return new InsCarFactory().create(line);
//            case 2:
//                return new InsPersGroupFactory().create(line);
//            case 3:
//                return new InsPersIndFactory().create(line);
//            default:
//                throw new CreateFactoryException(line);
//        }
//    }
//
//    static AbstractInsurance create() throws CreateFactoryException {
//        String ans = new Answers().readAnswerCmd(CHOICE_TYPE);
//        switch (Integer.parseInt(ans)) {
//            case 1:
//                return new InsCarFactory().create();
//            case 2:
//                return new InsPersGroupFactory().create();
//            case 3:
//                return new InsPersIndFactory().create();
//            default:
//                throw new CreateFactoryException("Выбран неверный тип страхования.");
//        }
//    }
}
