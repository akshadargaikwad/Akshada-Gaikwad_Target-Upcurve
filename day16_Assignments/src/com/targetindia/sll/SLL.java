package com.targetindia.sll;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import java.util.Scanner;
public class SLL {

    class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null; // this is the default behavior; no need to do this.
        }

    }

    ListNode head;
    int length;

    public void prepend(int data) {
        var newNode = new ListNode(data); // O(1)
        newNode.next = head; // O(1)
        head = newNode; // O(1)
        length++; // O(1)
    } // O(1)

    public void append(int data) {
        var newNode = new ListNode(data); // O(1)
        length++; // O(1)
        if (head == null) { // O(1)
            // list is empty; make the new node as the head
            head = newNode; // O(1)
            return; // O(1)
        }
        var curr = head;
        while (curr.next != null) { // O(n)
            curr = curr.next; // O(1)
        }

        curr.next = newNode;
    } // O(n)

    public void display() {
        var curr = head;
        System.out.print("HEAD -> ");
        while (curr != null) {
            System.out.print(curr.data);
            System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println("NULL");
    }
    public int size() {
        return this.length; // O(1)
    }

    public int indexOf(int data) {
        int index = 0;
        for (var curr = head; curr != null; curr = curr.next) { // O(n)
            if (data == curr.data) {
                return index;
            }
            index++;
        }
        return -1;
    } // O(n)

    public int deleteFirst() throws NoSuchElementException {
        if (head == null) { // O(1)
            throw new NoSuchElementException("list is empty!"); // O(1)
        }

        length--;
        var curr = head; // O(1)
        head = head.next; // O(1)
        curr.next = null; // detach the node from the list (for gc) // O(1)
        return curr.data; // O(1)
    } // O(1

    public void insert(int index, int data) throws IndexOutOfBoundsException {
        // todo: identify the worst case time complexity

        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        if (index == 0) {
            this.prepend(data);
            return;
        }

        if (index == length) {
            this.append(data);
            return;
        }

        var curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        var newNode = new ListNode(data);
        newNode.next = curr.next;
        curr.next = newNode;
        length++;
    }

    public int deleteAt(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        if (index == 0) {
            return this.deleteFirst();
        }

        var curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }

        var nodeToDelete = curr.next;
        curr.next = nodeToDelete.next;
        nodeToDelete.next = null;
        length--;
        return nodeToDelete.data;
    }
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        SLL list = new SLL();

        // let's populate the list with some initial values
        Stream.of(19, 49, 13, 59, 333, 283, 293, 100).forEach(list::append);

        the_loop:
        while (true) {
            list.display();
            System.out.println("\n*** Main Menu ***");
            System.out.println("0. Exit");
            System.out.println("1. Prepend");
            System.out.println("2. Append");
            System.out.println("3. Size");
            System.out.println("4. Search");
            System.out.println("5. Delete the first element");
            System.out.println("6. Insert data at a given index");
            System.out.println("7. Delete data at a given index");

            int choice;

            try {

            System.out.println("Enter your choice: ");
                choice=sc.nextInt();
            } catch (Exception e) {
                choice = -1;
            }

            switch (choice) {
                case 0:
                    System.out.println("Exiting...");
                    break the_loop;
                case 1:
                case 2:
                case 4:
                case 6:
                    try {
                        System.out.println("Enter data: ");
                        int data=sc.nextInt();
                        if (choice == 1) {
                            list.prepend(data);
                        } else if (choice == 2) {
                            list.append(data);
                        } else if (choice == 4) {
                            var index = list.indexOf(data);
                            if (index == -1) {
                                System.out.println("Data not found!");
                            } else {
                                System.out.println("Data found at index " + index);
                            }
                        } else if (choice == 6) {
                            System.out.println("Enter index: ");
                            int index=sc.nextInt();
                            list.insert(index, data);
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Invalid index for insertion");
                    } catch (Exception e) {
                        System.out.println("Invalid data type");
                    }
                    break;
                case 3:
                    System.out.println("Size = " + list.size());
                    break;
                case 5:
                    try {
                        int deleteData = list.deleteFirst();
                        System.out.println("Deleted data = " + deleteData);
                    } catch (NoSuchElementException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    try {
                        System.out.println("enter index : ");
                        int index=sc.nextInt();
                        int deleteData = list.deleteAt(index);
                        System.out.println("Deleted data = " + deleteData);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Invalid index for deletion");
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }


        }
    }



}
