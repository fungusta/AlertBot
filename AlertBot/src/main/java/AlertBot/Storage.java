package AlertBot;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Storage {
    private static List<Group> groupList = new ArrayList<>();

    public static void addGroup(Group group) {
        groupList.add(group);
    }

    public static void removeGroup(Group group) {
        groupList.remove(group);
    }

    public static void forEach(Consumer<? super Group> consumer) {
        groupList.forEach(consumer);
    }

    public static boolean contains(Group group) {
        return groupList.contains(group);
    }


}
