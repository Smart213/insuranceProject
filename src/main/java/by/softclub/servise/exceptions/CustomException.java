package by.softclub.servise.exceptions;

public class CustomException extends RuntimeException {

    public CustomException(String message) {
        super("Ошибка выполнения : " + message);
    }
}
