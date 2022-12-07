package AlertBot.Commands;

import static AlertBot.ResponseUtil.VALID_COMMAND_RESPONSE;
import static AlertBot.Commands.CommandUtil.REGISTER_COMMAND_MESSAGE;

public class RegisterCommand extends Command {

    private final Long chatId;

    public RegisterCommand(Long chatId) {
        this.chatId = chatId;
    }

    @Override
    public String execute() {
        //TODO: add the chatID to the google doc
        return toString() + " " + VALID_COMMAND_RESPONSE;
    }

    @Override
    public String toString() {
        return REGISTER_COMMAND_MESSAGE;
    }
}
