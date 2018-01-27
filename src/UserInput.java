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
            else if (msgtext.contains("/") ){
                String[] strArr = msgtext.split("/");
                Random r = new Random();
                int choice = r.nextInt(strArr.length);
                sendmessage = new SendMessage().setChatId(chat_id).setText(strArr[choice]+"\n");
            }
            if (msgtext.contains("doing")) {
                sendmessage = new SendMessage().setChatId(chat_id).setText("Thinking of you ❤️\n");
            }
            if (msgtext.contains("fuck") || msgtext.contains("stress")) {
                sendmessage = new SendMessage().setChatId(chat_id).setText("Chill girl (:\n");
            }

            if (msgtext.contains("break up") || msgtext.contains("give up") || msgtext.contains("quit") || msgtext.contains("bye")) {
                sendmessage = new SendMessage().setChatId(chat_id).setText("noooooooooo :(\n");
            }
            if (msgtext.equals("hi")|| msgtext.equals("hi ") || msgtext.contains("hello")||msgtext.equals("yo") || msgtext.contains("hey")) {
                sendmessage = new SendMessage().setChatId(chat_id).setText("what's up babe?\n");
            }
            if (msgtext.contains("sad")||msgtext.contains("stress")) {
                sendmessage = new SendMessage().setChatId(chat_id).setText("sendSadSticker");
            }
            if (msgtext.contains("love you")) {
                sendmessage = new SendMessage().setChatId(chat_id).setText("sendLoveSticker");
            }
            if (msgtext.contains("hate you")) {
                sendmessage = new SendMessage().setChatId(chat_id).setText("but I love you ❤️\n");
            }
            if (msgtext.contains("funny") || msgtext.contains("joke")) {
                sendmessage = new SendMessage().setChatId(chat_id).setText("sendFunnySticker");
            }
            if (msgtext.contains("who are you") || msgtext.contains("your name")) {
                sendmessage = new SendMessage().setChatId(chat_id).setText("I'm Zames baby ;)\n");
            }
            if (msgtext.contains("how old are you") || msgtext.contains("your age")) {
                sendmessage = new SendMessage().setChatId(chat_id).setText("21\n");
            }
            if (msgtext.contains("how are you")) {
                sendmessage = new SendMessage().setChatId(chat_id).setText("great! what about you?\n");
            }
            else {
                sendmessage = new SendMessage().setChatId(chat_id).setText("what lol\n");
            }
        }

        return sendmessage;
    }

}
