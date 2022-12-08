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
import static java.util.Objects.isNull;

public class Bot extends TelegramLongPollingBot {
    private static Group headGroup = null;
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
        Long id = msg.getChatId(); //remove later


        if (!msg.isCommand()) { //guard clause
            return;
        }
        String response;
        try {
            Command command = parseMessage(msg);
            response = command.execute(this);
        } catch (InvalidCommandException e) {
            response = ResponseUtil.INVALID_INPUT_RESPONSE;
        }
        sendText(id, response);
    }

    public void sendText(Long who, String what){
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString()) //Who are we sending a message to
                .text(what).build();    //Message content
        try {
            execute(sm);                        //Actually sending the message
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);      //Any error will be printed here
        }
    }

    public static void setHead(Group headGroup) {
        Bot.headGroup = headGroup;
    }

    public static boolean isHead(Group group) {
        if (isHeadNull()) {
            return false;
        }
        return Bot.headGroup.equals(group);
    }

    public static boolean isHeadNull() {
        return isNull(headGroup);
    }
}
