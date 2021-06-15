package by.softclub.servise.answers;

import by.softclub.entity.enums.MsgErrorEnum;
import by.softclub.entity.enums.QuestionEnum;
import by.softclub.servise.exceptions.CustomException;
import by.softclub.monitor.cmd.Dialog;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static by.softclub.entity.enums.MsgErrorEnum.NOT_VALID;

public class Answers {

    static final Logger logger = Logger.getLogger(Answers.class);

    private int count = 0;
    private static final int magNum = 3;

    private String read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    /**
     * читаю строку с консоли
     */
    public String readAnswerCmd(QuestionEnum questionEnum) {
        if (count > magNum) throw new CustomException(MsgErrorEnum.STOP.getText());
        Dialog dialog =
                new Dialog().sendRequest(questionEnum.getText());
        try {
            dialog.sendRequest(questionEnum.getListAns());
        } catch (CustomException e) {
            logger.info(e.getMessage());
        }
        String ans;
        try {
            ans = String.valueOf(read());
        } catch (IOException s) {
            ans = "";
        }
        if (!questionEnum.isValid(ans)) {
            count++;
            logger.info(NOT_VALID.getText() + "\nПопытка: " + count);
            new Dialog().sendRequest(NOT_VALID.getText());
            readAnswerCmd(questionEnum);
        }
        count = 0;
        return ans;
    }
}
