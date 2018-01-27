import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.exceptions.TelegramApiException;


public class Bot extends TelegramLongPollingBot {
    
    @Override
    public void onUpdateReceived(Update update){ 
        System.out.println(update.getMessage().getFrom().getFirstName()+ " " + update.getMessage().getText());
        
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId()); 
        sendMessage.setText("Hello" + update.getMessage().getFrom().getFirstName() + " \n" + update.getMessage().getText());

        UserInput userinput = new UserInput();
        sendMessage = userinput.handleUserInput(update);

        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
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
    
 
}


