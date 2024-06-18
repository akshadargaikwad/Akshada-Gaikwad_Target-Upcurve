import java.util.Arrays;
import java.util.Scanner;

class Array {

    private int[] numbers;
    private int size = 0;
    private int capacity = 5;

    public Array() {
        numbers = new int[capacity];
    }

    public void append(int data) {
        if (size == capacity) {
            capacity *= 2;
            var newNumbers = new int[capacity];
            for (int i = 0; i < size; i++) {
                newNumbers[i] = numbers[i];
            }
            numbers = newNumbers;
        }
        numbers[size++] = data;
    }

    public void display() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(numbers[i]);
            if (i < size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println("Array (raw) : " + Arrays.toString(numbers));
        System.out.println("Array content : " + sb);
    }

    public void prepend(int data) {
        if (size == capacity) {
            capacity *= 2;
        }
        var newNumbers = new int[capacity];
        newNumbers[0] = data;
        for (int i = 0; i < size; i++) {
            newNumbers[i + 1] = numbers[i];
        }
        numbers = newNumbers;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (size == 0) {
            throw new RuntimeException("empty array; nothing to delete");
        }
        if (index < 0 || index >= size) {
            throw new RuntimeException("Invalid index. Must be >=0 and <" + size);
        }
        int[] newNumbers = new int[capacity];
        for (int i = 0; i < index; i++) {
            newNumbers[i] = numbers[i];
        }
        for (int i = index + 1; i < size; i++) {
            newNumbers[i - 1] = numbers[i];
        }
        numbers = newNumbers;
        size--;
    }

    public void deleteValue(int value) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (numbers[i] == value) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            deleteAtIndex(index);
        } else {
            throw new RuntimeException("Value not found in the array");
        }
    }

    public void insertAt(int index, int data) {
        if (index < 0 || index > size) {
            throw new RuntimeException("Invalid index. Must be >=0 and <=" + size);
        }
        if (size == capacity) {
            capacity *= 2;
        }
        int[] newNumbers = new int[capacity];
        for (int i = 0; i < index; i++) {
            newNumbers[i] = numbers[i];
        }
        newNumbers[index] = data;
        for (int i = index; i < size; i++) {
            newNumbers[i + 1] = numbers[i];
        }
        numbers = newNumbers;
        size++;
    }

    public void reverse() {
        for (int i = 0; i < size / 2; i++) {
            int temp = numbers[i];
            numbers[i] = numbers[size - 1 - i];
            numbers[size - 1 - i] = temp;
        }
    }

    public void rotate(int k) {
        k = k % size;
        reverse();
        reverseSegment(0, k - 1);
        reverseSegment(k, size - 1);
    }

    private void reverseSegment(int start, int end) {
        while (start < end) {
            int temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
            start++;
            end--;
        }
    }
}

public class DSA {

    static Array array = new Array();

    public static void main(String[] args) {
        for (int i : Arrays.asList(19, 40, 29, 58, 55, 38, 31)) {
            array.append(i);
        }
        int choice;
        int data;
        int index;
        Scanner sc = new Scanner(System.in);
        do {
            array.display();
            System.out.println("***main menu***");
            System.out.println("0 Exit");
            System.out.println("1 Append");
            System.out.println("2 Prepend");
            System.out.println("3 Delete at Index");
            System.out.println("4 Delete a given value");
            System.out.println("5 Insert at a given index");
            System.out.println("6 Reverse");
            System.out.println("7 Rotate");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Exiting...");
                    break;
                case 1:
                    System.out.println("Enter data to append: ");
                    data = sc.nextInt();
                    array.append(data);
                    break;
                case 2:
                    System.out.println("Enter data to prepend: ");
                    data = sc.nextInt();
                    array.prepend(data);
                    break;
                case 3:
                    System.out.println("Enter index to delete value at: ");
                    index = sc.nextInt();
                    try {
                        array.deleteAtIndex(index);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Enter value to delete: ");
                    data = sc.nextInt();
                    try {
                        array.deleteValue(data);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Enter index to insert at: ");
                    index = sc.nextInt();
                    System.out.println("Enter data to insert: ");
                    data = sc.nextInt();
                    try {
                        array.insertAt(index, data);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    array.reverse();
                    System.out.println("Array reversed");
                    break;
                case 7:
                    System.out.println("Enter number of positions to rotate: ");
                    int k = sc.nextInt();
                    array.rotate(k);
                    System.out.println("Array rotated by " + k + " positions");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again");
            }
        } while (choice != 0);
    }
}
