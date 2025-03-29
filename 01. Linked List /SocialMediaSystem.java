import java.util.*;

class UserNode {
    int userID;
    String name;
    int age;
    UserNode next;
    LinkedList<Integer> friendIDs;

    public UserNode(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friendIDs = new LinkedList<>();
    }
}

public class SocialMediaSystem {
    private UserNode head = null;

    public void addUser(int userID, String name, int age) {
        UserNode newUser = new UserNode(userID, name, age);
        newUser.next = head;
        head = newUser;
    }

    public void addFriend(int userID1, int userID2) {
        UserNode user1 = findUser(userID1);
        UserNode user2 = findUser(userID2);
        if (user1 != null && user2 != null) {
            user1.friendIDs.add(userID2);
            user2.friendIDs.add(userID1);
        }
    }

    public void removeFriend(int userID1, int userID2) {
        UserNode user1 = findUser(userID1);
        UserNode user2 = findUser(userID2);
        if (user1 != null && user2 != null) {
            user1.friendIDs.remove(Integer.valueOf(userID2));
            user2.friendIDs.remove(Integer.valueOf(userID1));
        }
    }

    public void findMutualFriends(int userID1, int userID2) {
        UserNode user1 = findUser(userID1);
        UserNode user2 = findUser(userID2);
        if (user1 != null && user2 != null) {
            LinkedList<Integer> mutualFriends = new LinkedList<>(user1.friendIDs);
            mutualFriends.retainAll(user2.friendIDs);
            System.out.println("Mutual Friends: " + mutualFriends);
        }
    }

    public void displayAllFriends(int userID) {
        UserNode user = findUser(userID);
        if (user != null) {
            System.out.println("Friends of " + user.name + ": " + user.friendIDs);
        }
    }

    public void countFriends(int userID) {
        UserNode user = findUser(userID);
        if (user != null) {
            System.out.println(user.name + " has " + user.friendIDs.size() + " friends.");
        }
    }

    private UserNode findUser(int userID) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userID == userID) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SocialMediaSystem system = new SocialMediaSystem();
        system.addUser(1, "Alice", 25);
        system.addUser(2, "Bob", 30);
        system.addUser(3, "Charlie", 35);
        system.addFriend(1, 2);
        system.addFriend(2, 3);
        system.addFriend(1, 3);
        system.displayAllFriends(1);
        system.findMutualFriends(1, 2);
        system.countFriends(1);
        system.removeFriend(1, 2);
        system.displayAllFriends(1);
    }
}