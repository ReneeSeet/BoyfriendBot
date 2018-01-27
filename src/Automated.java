import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Automated extends Bot{
    Date currentTime = Calendar.getInstance().getTime();

    public void checkTime(ArrayList<User> userArr, int index) {

        long chat_id = userArr.get(index).getChatId();

        if (currentTime.getHours() == 19 && !userArr.get(index).getAsked()) {

            SendMessage sendMessage = new SendMessage().setChatId(chat_id).setText("Have you eaten?\n");
            userArr.get(index).setAsked(true);
            try {
                sendMessage(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

            SendPhoto sendPhoto = new SendPhoto();
            sendPhoto.setChatId(chat_id);
            sendPhoto.setPhoto("https://pm1.narvii.com/5813/46199134d8949225c26bbc0d5355510aa46f68d7_hq.jpg");
            try {
                sendPhoto(sendPhoto);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            sendMessage = new SendMessage().setChatId(chat_id).setText("I'm eating now haha\n");
            try {
                sendMessage(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

}
