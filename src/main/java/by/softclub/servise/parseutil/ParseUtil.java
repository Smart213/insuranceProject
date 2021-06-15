package by.softclub.servise.parseutil;

import by.softclub.entity.enums.QuestionEnum;
import by.softclub.servise.factory.exception.CreateFactoryException;

import java.util.List;

public class ParseUtil {

    public static String parseByTagSting(List<String> val, QuestionEnum tag) throws CreateFactoryException {
        return val.stream().filter(str -> str.contains(tag.getTag()))
                .findFirst()
                .orElseThrow(() -> new CreateFactoryException("Не найден параметр: " + tag))
                .split(":")[1].trim();
    }


    public static int parseByTagInt(List<String> val, QuestionEnum tag) throws CreateFactoryException {
        String category = parseByTagSting(val, tag);
        if (tag.isValid(category))
            return Integer.parseInt(category);
        else throw new CreateFactoryException("Оценочная стоимость содержит недопустимые данные.");
    }

    public static String parseByTagChar(List<String> val, QuestionEnum tag) throws CreateFactoryException {
        String category = parseByTagSting(val, tag);
        if (tag.isValid(category))
            return category;
        else throw new CreateFactoryException("Категория содержит недопустимые данные.");
    }
}
