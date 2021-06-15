package by.softclub.servise.factory.exception;

public class CreateFactoryException extends RuntimeException {

    public CreateFactoryException(String message) {
        super("Ошибка создания объекта : " + message);
    }
}
