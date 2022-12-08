package AlertBot.Commands;

import static AlertBot.BotUtil.BOT_USERNAME;
import static AlertBot.ResponseUtil.VALID_COMMAND_RESPONSE;

public class CommandUtil {
    public static final String REGISTER_COMMAND = "/register";
    public static final String REGISTER_COMMAND_IN_GROUPS = REGISTER_COMMAND + "@" + BOT_USERNAME;
    public static final String DUPLICATE_REGISTER_MESSAGE = "This group has already been registered";
    public static final String INVALID_REGISTER_OF_HEAD_GROUP_MESSAGE = "The head group cannot be registered";
    public static final String REGISTER_COMMAND_SUCCESS_MESSAGE = REGISTER_COMMAND + " " + VALID_COMMAND_RESPONSE;
    public static final String ALERT_COMMAND = "/alert";
    public static final String ALERT_COMMAND_IN_GROUPS = ALERT_COMMAND + "@" + BOT_USERNAME;
    public static final String NON_HEAD_CALLING_ALERT_COMMAND_MESSAGE = "This chat is not the main chat and cannot call alert";
    public static final String ALERT_COMMAND_SUCCESS_MESSAGE = ALERT_COMMAND + " " + VALID_COMMAND_RESPONSE;
    public static final String SET_HEAD_COMMAND  = "/sethead";
    public static final String SET_HEAD_COMMAND_IN_GROUPS = SET_HEAD_COMMAND + "@" + BOT_USERNAME;
    public static final String DUPLICATE_SET_HEAD_COMMAND = "This group is already the head";
    public static final String SET_HEAD_COMMAND_SUCCESS_MESSAGE = SET_HEAD_COMMAND + " " + VALID_COMMAND_RESPONSE;
}
