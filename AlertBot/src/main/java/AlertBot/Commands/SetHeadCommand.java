package AlertBot.Commands;

import AlertBot.Bot;
import AlertBot.Group;
import AlertBot.Storage;

import static AlertBot.Commands.CommandUtil.DUPLICATE_SET_HEAD_COMMAND;
import static AlertBot.Commands.CommandUtil.SET_HEAD_COMMAND_SUCCESS_MESSAGE;

public class SetHeadCommand extends Command {
    private final Long chatId;

    public SetHeadCommand(Long chatId) {
        this.chatId = chatId;
    }
    @Override
    public String execute(Bot bot) {
        Group group = new Group(chatId);
        if (!Bot.isHeadNull() && Bot.isHead(group)) {
            return DUPLICATE_SET_HEAD_COMMAND;
        }
        Bot.setHead(group);
        Storage.removeGroup(group);
        return SET_HEAD_COMMAND_SUCCESS_MESSAGE;
    }
}
