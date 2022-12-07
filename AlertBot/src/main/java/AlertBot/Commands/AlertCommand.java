package AlertBot.Commands;

import static AlertBot.ResponseUtil.VALID_COMMAND_RESPONSE;
import static AlertBot.Commands.CommandUtil.ALERT_COMMAND_MESSAGE;

public class AlertCommand extends Command {
    @Override
    public String execute() {
        //TODO: access the google sheets and alert all the chat IDs
        return toString() + " " + VALID_COMMAND_RESPONSE;
    }

    @Override
    public String toString() {
        return ALERT_COMMAND_MESSAGE;
    }
}
