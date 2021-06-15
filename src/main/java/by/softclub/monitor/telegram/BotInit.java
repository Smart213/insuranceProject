package by.softclub.monitor.telegram;

import by.softclub.ATelegramBase;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Arrays;

public class BotInit extends ATelegramBase {

    @Override
    public void onUpdateReceived(Update update) {

    }

    /**
     * ответ системным сообщением
     */
    private void sendAns(String text, Update update, boolean alert) {
        try {
            execute(new AnswerCallbackQuery()
                    .setCacheTime(20000)
                    .setCallbackQueryId(update.getCallbackQuery().getId())
                    .setShowAlert(alert)
                    .setText(text));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    /**
     * диалоговые кнопки
     */
    public InlineKeyboardMarkup sendCallbackButton() {
        return new InlineKeyboardMarkup()
                .setKeyboard(Arrays.asList(
                        Arrays.asList(
                                new InlineKeyboardButton("car").setCallbackData("CarInsurance"),
                                new InlineKeyboardButton("RealEstate").setCallbackData("RealEstateInsurance")),
                        Arrays.asList(
                                new InlineKeyboardButton("person").setCallbackData("InsuranceOfPersonIndividual"),
                                new InlineKeyboardButton("group").setCallbackData("InsuranceOfPersonGroup"))));
    }

    public void sendCallbackMsg(long id, String text) {
        try {
            execute(new SendMessage()
                    .enableMarkdown(false)
                    .setChatId(id)
                    .setText(text)
                    .setReplyMarkup(sendCallbackButton()));
        } catch (TelegramApiException ignored) {
        }
    }

    public void del(long chatId, int messageId) {
        try {
            execute(new DeleteMessage()
                    .setChatId(chatId)
                    .setMessageId(messageId));
        } catch (TelegramApiException ignored) {
        }
    }

    public synchronized void updateMessage(Update update, String newText) {
        try {
            execute(new EditMessageText()
                    .setText(newText)
                    .setMessageId(update.getCallbackQuery().getMessage().getMessageId())
                    .setChatId(update.getCallbackQuery().getMessage().getChatId())
                    .setReplyMarkup(sendCallbackButton()));
        } catch (TelegramApiException ignored) {
        }
    }
}
