package com.targetindia;
import java.util.Scanner;
public class CircularQueueUsingArray {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public CircularQueueUsingArray(int initialCapacity) {
        this.capacity = initialCapacity;
        this.queue = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void enqueue(int data) {
        if (isFull()) {
            resize();
        }
        rear = (rear + 1) % capacity;
        queue[rear] = data;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int data = queue[front];
        front = (front + 1) % capacity;
        size--;
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[front];
    }

    public int getSize() {
        return size;
    }

    private void resize() {
        int newCapacity = capacity * 2;
        int[] newArray = new int[newCapacity];

        // Copy elements to the new array
        for (int i = 0; i < size; i++) {
            newArray[i] = queue[(front + i) % capacity];
        }

        queue = newArray;
        front = 0;
        rear = size - 1;
        capacity = newCapacity;
    }

    public static void main(String[] args)
    {
        CircularQueueUsingArray queue=new CircularQueueUsingArray(4);
        int ch;
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("1.enqueue");
            System.out.println("2.dequeue");
            System.out.println("3.peek");
            System.out.println("4.size");

            System.out.println("enter your choice : ");
            ch=sc.nextInt();

            switch(ch)
            {
                case 1: System.out.println("enter data : ");
                    int data=sc.nextInt();
                    queue.enqueue(data);
                    break;

                case 2 :
                    queue.dequeue();
                    break;

                case 3: queue.peek();
                    break;

                case 4:
                    queue.getSize();
                    break;

                case 0:
                    System.out.println("existing....");
                    break;

                default :
                    System.out.println("enter correct choice");
            }


        }while(ch!=0);

    }



}
