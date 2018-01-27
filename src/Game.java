import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.Random;

public class Game extends Bot {

    int index=-1;
    int magicNum = -1;
    int currMin = 1;
    int currMax = 100;

    boolean finishGame = false;

    public Game() {
        Random r = new Random();
        magicNum = r.nextInt(99)+1;

    }

    public void play(int idx) {
        index = idx;
        sendText("Game Start!\nGuess what number from 1 to 100 I'm thinking of? ;)\n");
        System.out.println(magicNum);
    }

    public void guess(int guessNum) {

        if (guessNum<1 || guessNum>100) {
            sendText("Number must be between 1 and 100\n");
            return;
        }
        if (guessNum == magicNum) {
            finishGame = true;
            sendText("Yes you got it!\n");
        }
        else if (guessNum<magicNum) {
            if (currMin>magicNum)
                currMin = magicNum;
            sendText("Higher\n");
        }
        else {
            if (currMax>magicNum)
                currMax = magicNum;
            sendText("Lower\n");
        }
    }

    private void sendText(String str) {
        SendMessage sendMessage = new SendMessage().setChatId(userArr.get(index).getChatId()).setText(str);
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
