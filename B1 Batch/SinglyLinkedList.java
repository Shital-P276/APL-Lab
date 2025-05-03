class SinglyLinkedList {
    private Node head;

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void deleteByValue(int data) {
        if (head == null) return;

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int choice, value;

        while (true) {
            System.out.println("\nSingly Linked List Operations");
            System.out.println("1. Insert at end");
            System.out.println("2. Insert at beginning");
            System.out.println("3. Delete by value");
            System.out.println("4. Search for value");
            System.out.println("5. Display list");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert at end: ");
                    value = scanner.nextInt();
                    list.insertAtEnd(value);
                    break;
                case 2:
                    System.out.print("Enter value to insert at beginning: ");
                    value = scanner.nextInt();
                    list.insertAtBeginning(value);
                    break;
                case 3:
                    System.out.print("Enter value to delete: ");
                    value = scanner.nextInt();
                    list.deleteByValue(value);
                    break;
                case 4:
                    System.out.print("Enter value to search: ");
                    value = scanner.nextInt();
                    System.out.println("Value " + value + " exists: " + list.search(value));
                    break;
                case 5:
                    System.out.print("Current list: ");
                    list.display();
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
