package by.softclub;

import by.softclub.entity.enums.BotInitEnum;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public abstract class ATelegramBase extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return BotInitEnum.NAME_BOT.getValue();
    }

    @Override
    public String getBotToken() {
        return BotInitEnum.TOKEN.getValue();
    }
}
