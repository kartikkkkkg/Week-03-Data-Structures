import java.util.Scanner;

class ItemNode {
    String itemName;
    int itemID;
    int quantity;
    double price;
    ItemNode next;

    public ItemNode(String itemName, int itemID, int quantity, double price) {
        this.itemName = itemName;
        this.itemID = itemID;
        this.quantity = quantity;
        this.price = price;
    }
}

public class InventorySystem {
    private ItemNode head = null;

    public void addItemAtBeginning(String itemName, int itemID, int quantity, double price) {
        ItemNode newItem = new ItemNode(itemName, itemID, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    public void addItemAtEnd(String itemName, int itemID, int quantity, double price) {
        ItemNode newItem = new ItemNode(itemName, itemID, quantity, price);
        if (head == null) {
            head = newItem;
        } else {
            ItemNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newItem;
        }
    }

    public void removeItemByID(int itemID) {
        if (head == null) {
            System.out.println("No items to remove.");
            return;
        }
        ItemNode temp = head;
        ItemNode prev = null;
        while (temp != null && temp.itemID != itemID) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Item ID " + itemID + " not found.");
        } else {
            if (prev != null) {
                prev.next = temp.next;
            } else {
                head = temp.next;
            }
            System.out.println("Item " + itemID + " removed.");
        }
    }

    public void updateQuantity(int itemID, int newQuantity) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemID == itemID) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated for item ID " + itemID);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item ID " + itemID + " not found.");
    }

    public double calculateTotalInventoryValue() {
        double totalValue = 0;
        ItemNode temp = head;
        while (temp != null) {
            totalValue += temp.price * temp.quantity;
            temp = temp.next;
        }
        return totalValue;
    }

    public void displayInventory() {
        ItemNode temp = head;
        while (temp != null) {
            System.out.println("Item Name: " + temp.itemName + ", Item ID: " + temp.itemID + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventorySystem inventory = new InventorySystem();
        System.out.println("Enter item details to add at the beginning:");
        System.out.print("Item Name: ");
        String itemName = scanner.nextLine();
        System.out.print("Item ID: ");
        int itemID = scanner.nextInt();
        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        inventory.addItemAtBeginning(itemName, itemID, quantity, price);
        System.out.println("Enter item details to add at the end:");
        System.out.print("Item Name: ");
        itemName = scanner.nextLine();
        System.out.print("Item ID: ");
        itemID = scanner.nextInt();
        System.out.print("Quantity: ");
        quantity = scanner.nextInt();
        System.out.print("Price: ");
        price = scanner.nextDouble();
        inventory.addItemAtEnd(itemName, itemID, quantity, price);
        inventory.displayInventory();
        System.out.print("Enter Item ID to remove: ");
        itemID = scanner.nextInt();
        inventory.removeItemByID(itemID);
        System.out.print("Enter Item ID to update quantity: ");
        itemID = scanner.nextInt();
        System.out.print("Enter new quantity: ");
        quantity = scanner.nextInt();
        inventory.updateQuantity(itemID, quantity);
        System.out.println("Total Value: " + inventory.calculateTotalInventoryValue());
        inventory.displayInventory();
    }
}