package com.targetindia;

import java.util.Scanner;

public class QueueUsingSLL {

    class Node
    {
        int data;
        Node next;

        public Node(int data)
        {
            this.data=data;
            this.next=null;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public QueueUsingSLL()
    {
        this.front=null;
                this.rear=null;
                this.size=0;
    }

    public void enqueue(int data)
    {
        Node newnode=new Node(data);
        if(rear==null)
        {
            front=rear=newnode;
        }
        else{
           rear.next=newnode;
           rear=newnode;
        }
        size++;
    }

    public int dequeue()
    {
        if(front==null)
        {
            throw new IllegalStateException("queue is empty");

        }
        int data=front.data;
        front=front.next;
        if(front==null)
        {
            rear=null;
        }
        size--;
        return data;
    }

    public int peek()
    {
        if(front==null)
        {
            throw new IllegalStateException(("queue is empty"));
        }

        return front.data;
    }

    public boolean isEmpty()
    {
        return size==0;
    }

    public int getSize()
    {
        return size;
    }
    public void displayQueue()
    {
        if(isEmpty())
        {
            throw new IllegalStateException("queue is empty");


        }
        else{
            Node temp=front;
            while(temp!=rear)
            {
                System.out.print(temp.data+" ");
            }
        }
    }

    public static void main(String[] args)
    {
        QueueUsingSLL queue=new QueueUsingSLL();
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

