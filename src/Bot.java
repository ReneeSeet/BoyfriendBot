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
    static ArrayList<User> userArr = new ArrayList<User>();
    public static boolean start = false;
    public boolean playingGame = false;

    public static Game game;

    public Bot() {
        initialiseStickerArr();

    }

    @Override
    public void onUpdateReceived(Update update){
        System.out.println(update.getMessage().getFrom().getFirstName()+ " " + update.getMessage().getText());

        User user = new User(update.getMessage().getChatId());
        int index = 0;

        UserInput userinput = new UserInput();
        if (userArr.size() == 0)
            userArr.add(user);
        else {
            boolean userExists = false;
            for (int i=0; i<userArr.size(); i++) {
                if (update.getMessage().getChatId() == userArr.get(i).getChatId()) {
                    userExists = true;
                    index = i;
                    break;
                }
            }
            if (!userExists) {
                userArr.add(user);
                index = userArr.size()-1;
            }
        }
        if (update.getMessage().hasText() && update.getMessage().getText().equals("/play")) {
            game = new Game();
            game.play(index);
            playingGame = true;
            return;
        }
        else if (playingGame) {
            if (!game.finishGame)
                game.guess(Integer.valueOf(update.getMessage().getText()));
            else
                playingGame = false;
        }

        ArrayList<SendMessage> sendMessageArrayList = new ArrayList<SendMessage>();
        sendMessageArrayList = userinput.handleUserInput(update);

        int currIndex = 0;
        for (int i=0; i<userArr.size(); i++) {
            if (userArr.get(i).getStopped())
                System.out.println("hey "+ userArr.get(i).getChatId());
        }

        while (!playingGame && !sendMessageArrayList.isEmpty() && currIndex<sendMessageArrayList.size() && !userArr.get(currIndex).getStopped()) {

            SendMessage sendMessage = sendMessageArrayList.get(currIndex);

            if (sendMessage.getText().equals("sendSadSticker")) {
                SendSticker sendsticker = new SendSticker();
                sendsticker.setChatId(update.getMessage().getChatId());
                Random r = new Random();
                int choice = r.nextInt(sadStickerArr.size());

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
                int choice = r.nextInt(loveStickerArr.size());

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
                int choice = r.nextInt(funnyStickerArr.size());

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
            currIndex++;
        }


        if (userArr.size() != 0 && !start) {
            start = true;
            Automated automated = new Automated();
            automated.checkTime(userArr);
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
        funnyStickerArr.add("CAADBQADUgADSLFzBD7I9m-w-bGNAg");
        funnyStickerArr.add("CAADAgADHQcAAlwCZQM-0Qp3K2vK8AI");
        funnyStickerArr.add("CAADAgADRwcAAlwCZQNtRySfx0ALSQI");
        funnyStickerArr.add("CAADBQADwQIAAkVfjQJ1j3zMc89mEwI");
        funnyStickerArr.add("CAADBQADERQAAkVfjQIRHwaSpEYrXAI");
        funnyStickerArr.add("CAADBQADEAYAAnsVRgmMMLrrm60dAwI");
        funnyStickerArr.add("CAADBAADQxIAAvEGNAbffGeFP3iKKgI");
        funnyStickerArr.add("CAADAwADiwEAAmLypQAB93JW-kg6ZK8C");
        funnyStickerArr.add("CAADAwADfwEAAmLypQABKupgB1jlwIoC");
        funnyStickerArr.add("CAADBQADxAIAAqMFQQdiVXzEMseclAI");
        funnyStickerArr.add("CAADBQADFgADKJ12BLbLdvtafXUhAg");
        funnyStickerArr.add("CAADBQADLwADgIb7AS1WIV1w3QSgAg");
        funnyStickerArr.add("CAADBQADagADLXDJAk1OHETxRvdrAg");
        funnyStickerArr.add("CAADBQADdQADSLFzBLeFCJuli-QfAg");

    }
    
 
}


