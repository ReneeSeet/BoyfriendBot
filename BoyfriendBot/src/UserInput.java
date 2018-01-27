import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendSticker;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.api.objects.Sticker;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import java.util.Random;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.random;
import static java.lang.Math.toIntExact;

public class UserInput extends Bot{

    public SendMessage handleUserInput(Update update) {
        SendMessage sendmessage = null;
        long chat_id = update.getMessage().getChatId();

        if (update.hasMessage() && update.getMessage().hasText()) {
            String msgtext = update.getMessage().getText().toLowerCase();

            if (msgtext.equals("/start")) {
                sendmessage = new SendMessage().setChatId(chat_id).setText("Hello\n");
            }
            else if (msgtext.contains("doing")) {
                sendmessage = new SendMessage().setChatId(chat_id).setText("Thinking of you <3\n");
            }
            else if (msgtext.contains("fuck") || msgtext.contains("stress")) {
                sendmessage = new SendMessage().setChatId(chat_id).setText("Chill girl (:\n");
            }
            else if (msgtext.contains(";") ){
                String[] strArr = msgtext.split(";");
                Random r = new Random();
                int choice = r.nextInt(strArr.length) + 1;
                sendmessage = new SendMessage().setChatId(chat_id).setText(strArr[choice]+"\n");
            }
            else if (msgtext.contains("sad")) {
                sendmessage = new SendMessage().setChatId(chat_id).setText("sendSadSticker");
            }
            else if (msgtext.contains("love you")) {
                sendmessage = new SendMessage().setChatId(chat_id).setText("sendLoveSticker");
            }
            else if (msgtext.contains("funny") || msgtext.contains("joke")) {
                sendmessage = new SendMessage().setChatId(chat_id).setText("sendFunnySticker");
            }
            else {
                sendmessage = new SendMessage().setChatId("what lol\n");
            }
        }

        return sendmessage;
    }

}
