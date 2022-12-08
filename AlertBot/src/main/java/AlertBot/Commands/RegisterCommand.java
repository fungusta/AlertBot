package AlertBot.Commands;

import AlertBot.Bot;
import AlertBot.Group;
import AlertBot.Storage;

import static AlertBot.Commands.CommandUtil.DUPLICATE_REGISTER_MESSAGE;
import static AlertBot.Commands.CommandUtil.INVALID_REGISTER_OF_HEAD_GROUP_MESSAGE;
import static AlertBot.Commands.CommandUtil.REGISTER_COMMAND_SUCCESS_MESSAGE;

public class RegisterCommand extends Command {
    private final Long chatId;

    public RegisterCommand(Long chatId) {
        this.chatId = chatId;
    }

    @Override
    public String execute(Bot bot) {
        Group newGroup = new Group(chatId);
        if (Storage.contains(newGroup)) {
            return DUPLICATE_REGISTER_MESSAGE;
        }
        if (Bot.isHead(newGroup)) {
            return INVALID_REGISTER_OF_HEAD_GROUP_MESSAGE;
        }
        Storage.addGroup(newGroup);
        return REGISTER_COMMAND_SUCCESS_MESSAGE;
    }
}
