import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.*;

public class Automated extends Bot{
    Date currentTime = Calendar.getInstance().getTime();
    private static int seconds = 0;

//    public Automated() {
//        MyTimer();
//    }

//    public static void MyTimer() {
//        Timer timer = new Timer();
//        TimerTask task;
//        task = new TimerTask() {
//            @Override
//            public void run() {
//                if (seconds < 2) {
//                    //System.out.println("helloooo123\n");
//                    seconds++;
//                }
//                else {
//                    //stop the timer
//                    cancel();
//                }
//            }
//        };
//        timer.schedule(task, 0, 1000);
//    }

    public void checkTime(ArrayList<User> userArr) {
        int index;

        for (int i=0; i<userArr.size(); i++){
            index = i;

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

}
