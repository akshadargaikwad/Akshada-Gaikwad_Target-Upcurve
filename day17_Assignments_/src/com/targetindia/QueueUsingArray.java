package com.targetindia;

public class QueueUsingArray {

    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public QueueUsingArray(int capacity)
    {
        this.capacity=capacity;
        this.queue=new int[capacity];
        this.front=0;
        this.rear=-1;
        this.size=0;
    }

    public boolean isEmpty()
    {
        return size==0;
    }

    public boolean isFull()
    {
        return size==capacity;
    }

    public void enqueue(int data)
    {
        if(isFull())
        {
            throw new IllegalStateException("queue is full");
        }
        rear=(rear+1)%capacity;
        queue[rear]=data;
        size++;
    }

    public int dequeue()
    {
        if(isEmpty())
        {
            throw new IllegalStateException("queue is empty");
        }
        int data=queue[front];
        front=(front+1)%capacity;
        size--;
        return data;
    }

    public int peek()
    {
        if(isEmpty())
        {
            throw new IllegalStateException("queue is empty");
        }
        return queue[front];
    }

    public int getsize()
    {
        return size;
    }
    public static void main(String[] args)
    {
        QueueUsingArray queue=new QueueUsingArray(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("front element is : "+queue.peek());
        System.out.println("queue size is : "+queue.getsize());
        System.out.println("dequeued element is : "+queue.dequeue());
        System.out.println("front element is : "+queue.peek());
        System.out.println("queue size is : "+queue.getsize());
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        System.out.println("queue is full : "+queue.isFull());
    }
}
