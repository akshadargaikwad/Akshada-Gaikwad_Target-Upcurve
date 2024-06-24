package com.targetindia;

public class DoublyLinkedListStack {

    class Node{
        int data;
        Node prev;
        Node next;

        public Node(int data)
        {
            this.data=data;
            this.prev=null;
            this.next=null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedListStack(){
        this.head=null;
        this.tail=null;
        this.size=0;
    }

    //push operation
    public void push(int data)
    {
        Node newnode=new Node(data);
        if(tail==null)
        {
            head=tail=newnode;
        }
        else{
            tail.next=newnode;
            newnode.prev=tail;
            tail=newnode;
        }

        size++;
    }

    //pop operation
    public int pop()
    {
        if(tail==null)
        {
            throw new IllegalStateException("stack is empty");
        }
        int data=tail.data;
        if(tail==head)  //only one element is there
        {
         head=tail=null;
        }
        else{
            tail=tail.prev;
            tail.next=null;
        }
        size--;
        return data;
    }

    //peek operation
    public int peek()
    {
        if(tail==null)
        {
            throw new IllegalStateException("stack is empty");
        }
        return tail.data;
    }

    public boolean isEmpty()
    {
        return size==0;
    }
    public int getSize()
    {
        return size;
    }

    public static void main(String[] args)
    {
        DoublyLinkedListStack stack=new DoublyLinkedListStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        System.out.println("top element is : "+stack.peek());
        System.out.println("stack size is : "+stack.getSize());
        System.out.println("popped element is : "+stack.pop());
        System.out.println("top element is : "+stack.pop());
        System.out.println("stack size is : "+stack.getSize());
    }

}
