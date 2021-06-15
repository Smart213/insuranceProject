package by.softclub.entity.enums;

import by.softclub.servise.exceptions.CustomException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@Getter
@AllArgsConstructor
public enum QuestionEnum {

    START_MENU("введите ответ", null) {
        public List<String> getListAns() {
            return Arrays.asList(
                    "1 - Ввести данные",
                    "2 - Взять из файла");
        }

        public boolean isValid(String act) {
            return Pattern.matches("[1,2]", act);
        }
    },

    CHOICE_TYPE("Выбери тип страхования", null) {
        public List<String> getListAns() {
            return Arrays.asList(
                    "1 - Страхование авто",
                    "2 - Страхование групповое",
                    "3 - Страхование индивидуальное");
        }

        public boolean isValid(String act) {
            return Pattern.matches("[1-3]", act);
        }
    },
    NAME("Введите имя", "name") {
        public boolean isValid(String act) {
            return Pattern.matches("\\w+", act);
        }
    },
    ASSESSED_VALUE("Введите оценочную стоимость автомобиля", "assessedValue") {
        public boolean isValid(String act) {
            return Pattern.matches("\\d+", act);
        }
    },
    CATEGORY("Введите категорю транспортного средства.", "category") {
        public boolean isValid(String act) {
            return act.length() == 1 && Pattern.matches("[A-E]", act.toUpperCase());
        }
    },
    GROUP_SIZE("Введите размер группы.", "groupSize") {
        public boolean isValid(String act) {
            return Pattern.matches("\\d+", act) && Integer.parseInt(act) > 1;
        }
    },
    RISK_RATIO("Введите повышающий коофицент.", "riskRatio") {
        public boolean isValid(String act) {
            return Pattern.matches("\\d+", act);
        }
    },
    ID("Введите ID", "id");
    private final String text;
    private final String tag;

    public boolean isValid(String act) {
        throw new CustomException("не определен метод для вопроса.");
    }

    public List<String> getListAns() {
        throw new CustomException("Нет вариантов ответа.");
    }
}
