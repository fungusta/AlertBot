package AlertBot;

import AlertBot.Commands.AlertCommand;
import AlertBot.Commands.Command;
import AlertBot.Commands.InvalidCommandException;
import AlertBot.Commands.RegisterCommand;
import AlertBot.Commands.SetHeadCommand;
import org.telegram.telegrambots.meta.api.objects.Message;

import static AlertBot.Commands.CommandUtil.ALERT_COMMAND;
import static AlertBot.Commands.CommandUtil.ALERT_COMMAND_IN_GROUPS;
import static AlertBot.Commands.CommandUtil.REGISTER_COMMAND;
import static AlertBot.Commands.CommandUtil.REGISTER_COMMAND_IN_GROUPS;
import static AlertBot.Commands.CommandUtil.SET_HEAD_COMMAND;
import static AlertBot.Commands.CommandUtil.SET_HEAD_COMMAND_IN_GROUPS;

public class Parser {
    public static Command parseMessage(Message message) throws InvalidCommandException {
        Long chatId = message.getChatId();
        switch (message.getText()) {
        case ALERT_COMMAND:
        case ALERT_COMMAND_IN_GROUPS:
            return new AlertCommand(chatId);
        case REGISTER_COMMAND:
        case REGISTER_COMMAND_IN_GROUPS:
            return new RegisterCommand(chatId);
        case SET_HEAD_COMMAND:
        case SET_HEAD_COMMAND_IN_GROUPS:
            return new SetHeadCommand(chatId);
        default:
            throw new InvalidCommandException();
        }
    }
}
