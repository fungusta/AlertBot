package AlertBot;

import AlertBot.Commands.AlertCommand;
import AlertBot.Commands.Command;
import AlertBot.Commands.InvalidCommandException;
import AlertBot.Commands.RegisterCommand;
import org.telegram.telegrambots.meta.api.objects.Message;

import static AlertBot.Commands.CommandUtil.ALERT_COMMAND_MESSAGE;
import static AlertBot.Commands.CommandUtil.REGISTER_COMMAND_MESSAGE;

public class Parser {
    public static Command parseMessage(Message message) throws InvalidCommandException {
        if(message.isCommand()) {
            switch (message.getText()) {
                case REGISTER_COMMAND_MESSAGE:
                    Long chatId = message.getChatId();
                    return new RegisterCommand(chatId);
                case ALERT_COMMAND_MESSAGE:
                    return new AlertCommand();
                default:
                    throw new InvalidCommandException();
            }
        }
        throw new InvalidCommandException();
    }
}
