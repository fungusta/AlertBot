package AlertBot;
import AlertBot.Commands.Command;
import AlertBot.Commands.InvalidCommandException;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static AlertBot.BotUtil.BOT_TOKEN;
import static AlertBot.BotUtil.BOT_USERNAME;
import static AlertBot.Parser.parseMessage;

public class Bot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message msg = update.getMessage();
        Long id = msg.getChatId();

        /*
        If alert, alert the groups that are stored
        If register, register
        Else response the others
         */
        if (!msg.isCommand()) { //guard clause
            return;
        }
        String response = null;
        try {
            Command command = parseMessage(msg);
            response = command.execute();
        } catch (InvalidCommandException e) {
            response = ResponseUtil.INVALID_INPUT_RESPONSE;
        }
        sendText(id, response);
    }

    private void sendText(Long who, String what){
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString()) //Who are we sending a message to
                .text(what).build();    //Message content
        try {
            execute(sm);                        //Actually sending the message
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);      //Any error will be printed here
        }
    }
}
