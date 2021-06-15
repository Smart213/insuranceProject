package by.softclub.monitor.cmd;

import java.util.List;

public class Dialog {

    public Dialog sendRequest(String text) {
        System.out.println(text);
        return this;
    }

    public Dialog sendRequest(List<String> list) {
        list.forEach(this::sendRequest);
        return this;
    }
}
