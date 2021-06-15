package by.softclub.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MsgErrorEnum {
    NOT_VALID("Данные невалидны, повторите ввод."),
    STOP("Ввод остановлен, количество попыток ввода превысило максимальное.");
    private final String text;
}
