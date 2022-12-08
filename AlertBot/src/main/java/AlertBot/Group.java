package AlertBot;

public class Group {
    private final Long chatId;

    public Group(Long chatId) {
        this.chatId = chatId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Group) {
            Group otherGroup = (Group) obj;
            return this.chatId.equals(otherGroup.chatId);
        }
        return false;
    }

    public Long getChatId() {
        return chatId;
    }
}
