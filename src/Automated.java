import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Automated extends Bot{
    Date currentTime = Calendar.getInstance().getTime();

    public void checkTime(ArrayList<User> userArr, int index) {

        if (currentTime.getHours() == 19 && !userArr.get(index).getAsked()) {

            SendMessage sendMessage = new SendMessage().setChatId(userArr.get(index).getChatId()).setText("Have you eaten?\n");
            userArr.get(index).setAsked(true);
            try {
                sendMessage(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

}
