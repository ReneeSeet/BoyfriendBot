import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendSticker;
import org.telegram.telegrambots.api.objects.Sticker;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Random;


public class Bot extends TelegramLongPollingBot {
    ArrayList<String> sadStickerArr = new ArrayList<String>();
    ArrayList<String> loveStickerArr = new ArrayList<String>();
    ArrayList<String> funnyStickerArr = new ArrayList<String>();

    public Bot() {
        initialiseStickerArr();
    }
    
    @Override
    public void onUpdateReceived(Update update){ 
        System.out.println(update.getMessage().getFrom().getFirstName()+ " " + update.getMessage().getText());
        
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId()); 
        sendMessage.setText("Hello" + update.getMessage().getFrom().getFirstName() + " \n" + update.getMessage().getText());

        UserInput userinput = new UserInput();
        sendMessage = userinput.handleUserInput(update);

        if (sendMessage!=null) {
            if (sendMessage.getText().equals("sendSadSticker")) {
                SendSticker sendsticker = new SendSticker();
                sendsticker.setChatId(update.getMessage().getChatId());
                Random r = new Random();
                int choice = r.nextInt(sadStickerArr.size() + 1);

                sendsticker.setSticker(sadStickerArr.get(choice));
                try {
                    sendSticker(sendsticker);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (sendMessage.getText().equals("sendLoveSticker")) {
                SendSticker sendsticker = new SendSticker();
                sendsticker.setChatId(update.getMessage().getChatId());
                Random r = new Random();
                int choice = r.nextInt(loveStickerArr.size() + 1);

                sendsticker.setSticker(loveStickerArr.get(choice));
                try {
                    sendSticker(sendsticker);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (sendMessage.getText().equals("sendFunnySticker")) {
                SendSticker sendsticker = new SendSticker();
                sendsticker.setChatId(update.getMessage().getChatId());
                Random r = new Random();
                int choice = r.nextInt(funnyStickerArr.size() + 1);

                sendsticker.setSticker(funnyStickerArr.get(choice));
                try {
                    sendSticker(sendsticker);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    sendMessage(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
        else {
            SendSticker sendsticker = new SendSticker();
            sendsticker.setChatId(update.getMessage().getChatId());
            Random r = new Random();
            int choice = r.nextInt(funnyStickerArr.size() + 1);

            sendsticker.setSticker(funnyStickerArr.get(choice));
            try {
                sendSticker(sendsticker);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public String getBotToken() {
        return "402898203:AAHSlk20D6VXpg75YD0T_4ZqBhPn7uYFXGQ";
    }
    
    @Override
    public String getBotUsername(){ 
        return null;
    }

    public void initialiseStickerArr() {
        sadStickerArr.add("CAADBQADfgEAAhUO6gKFmvydECFOgwI");
        sadStickerArr.add("CAADBQADZQEAAhUO6gKpcmYaLRFwcwI");
        sadStickerArr.add("CAADBQADZwEAAhUO6gJKW1Vr5oDOeAI");
        sadStickerArr.add("CAADBQADaAEAAhUO6gIFjx3DJlVJBwI");
        sadStickerArr.add("CAADBQADvQIAAr693gOZvGeTpjgQwAI");
        sadStickerArr.add("CAADBQADfwMAAnsVRglzTxkxAyWT6wI");

        loveStickerArr.add("CAADBQADhQEAAhUO6gKFz02SvfA1PQI");
        loveStickerArr.add("CAADBQAD9QgAAkVfjQKfo67yfEqQUwI");
        loveStickerArr.add("CAADBQADxQIAAkVfjQKMImWb4DhOygI");
        loveStickerArr.add("CAADAQADLAMAAnTnKwLj8EsT6uoBNwI");
        loveStickerArr.add("CAADAwAD5wADYvKlAAFuSoPAPeqnrAI");
        loveStickerArr.add("CAADAwADbAEAAmLypQABiEVKsWQwyboC");
        loveStickerArr.add("CAADBQADkQADwRH0AnjtpQABs3gthgI");
        loveStickerArr.add("CAADBQADeQEAAsER9ALw0f1TdhYOXgI");
        loveStickerArr.add("CAADBQADGAcAAszG4gK5TgnCYv-AgQI");
        loveStickerArr.add("CAADBQADvwADwRH0AgmLfMj45Y6GAg");
        loveStickerArr.add("CAADBQADKwEAAsER9AJUVfWCpedcwQI");
        loveStickerArr.add("CAADBQADfwMAAnsVRglzTxkxAyWT6wI");
        loveStickerArr.add("CAADBAADSRIAAvEGNAYR8_UUzMHVLQI");

        funnyStickerArr.add("CAADAgADTgcAAlwCZQN5kCc_E9kn6wI");
//        funnyStickerArr.add("");
//        funnyStickerArr.add("");
//        funnyStickerArr.add("");
//        funnyStickerArr.add("");
//        funnyStickerArr.add("");
//        funnyStickerArr.add("");
//        funnyStickerArr.add("");
//        funnyStickerArr.add("");
//        funnyStickerArr.add("");
//        funnyStickerArr.add("");
//        funnyStickerArr.add("");
//        funnyStickerArr.add("");

    }
    
 
}


