package AlertBot.Commands;

import AlertBot.Bot;
import AlertBot.Group;
import AlertBot.Storage;

import static AlertBot.Commands.CommandUtil.ALERT_COMMAND_SUCCESS_MESSAGE;
import static AlertBot.Commands.CommandUtil.NON_HEAD_CALLING_ALERT_COMMAND_MESSAGE;

public class AlertCommand extends Command {
    private final Long callerChatId;
    private static final String ALERT_MESSAGE = "ALERTING YOU";

    public AlertCommand(Long callerChatId) {
        this.callerChatId = callerChatId;
    }

    @Override
    public String execute(Bot bot) {
        if (!Bot.isHead(new Group(callerChatId))) {
            return NON_HEAD_CALLING_ALERT_COMMAND_MESSAGE;
        }
        Storage.forEach(group -> bot.sendText(group.getChatId(), ALERT_MESSAGE));
        return ALERT_COMMAND_SUCCESS_MESSAGE;
    }
}
