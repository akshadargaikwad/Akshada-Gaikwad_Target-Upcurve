package com.targetindia;

public class DLLSorting {

    private class Node{
        int data;
        Node prev;
        Node next;

        Node(int data)
        {
            this.data=data;
            this.prev=null;
            this.next=null;
        }
    }

    private Node head;
    private Node tail;

    public DLLSorting()
    {
        this.head=null;
        this.tail=null;
    }

    public void add(int data)
    {
        Node newnode=new Node(data);
        if(head==null)
        {
            head=newnode;
        }
        else{
            Node temp=head;
            while(temp.next!=null)
            {
                temp=temp.next;
            }
            temp.next=newnode;
            newnode.prev=temp;
        }
    }


    //bubble sort
    public void bubbleSort()
    {
        if(head==null)
        {
            return ;
        }

        boolean swapped;
        Node current;
        do {
            swapped = false;
            current = head;
            while (current.next != null) {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        }while(swapped);
    }

    //selection sort
    public void selectionSort()
    {
        if(head==null)

        {
            return;
        }

        Node curr=head;
        while(curr!=null)
        {
            Node min=curr;
            Node next=curr.next;

            while(next!=null)
            {
                if(next.data<min.data)
                {
                    min=next;
                }
                next=next.next;
            }

            if(min!=curr)
            {
                int temp=curr.data;
                curr.data=min.data;
                min.data=temp;
            }
            curr=curr.next;
        }
    }

    //insertion sort
    public void insertionSort()
    {
        if(head==null)
        {
            return;
        }
        Node curr=head.next;
        while(curr!=null)
        {
            int key=curr.data;
            Node prev=curr.prev;

            while(prev!=null && prev.data>key)
            {
                prev.next.data=prev.data;
                prev=prev.next;
            }

            if(prev==null)
            {
                head.data=key;
            }
            else{
                prev.next.data=key;
            }

            curr=curr.next;
        }
    }

    public void print()
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        DLLSorting list = new DLLSorting();
        list.add(4);
        list.add(3);
        list.add(5);
        list.add(1);
        list.add(2);

        System.out.println("Original List:");
        list.print();

        list.bubbleSort();
        System.out.println("List after Bubble Sort:");
        list.print();

        list = new DLLSorting();
        list.add(4);
        list.add(3);
        list.add(5);
        list.add(1);
        list.add(2);

        list.selectionSort();
        System.out.println("List after Selection Sort:");
        list.print();

        list = new DLLSorting();
        list.add(4);
        list.add(3);
        list.add(5);
        list.add(1);
        list.add(2);

        list.insertionSort();
        System.out.println("List after Insertion Sort:");
        list.print();
    }
}
