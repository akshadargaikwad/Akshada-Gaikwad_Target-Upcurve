package com.targetindia.dll;
import java.util.stream.Stream;
import java.util.NoSuchElementException;
import java.util.Scanner;
import com.targetindia.sll.SLL;
public class DLL {


    class ListNode {
        ListNode prev;
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private ListNode head;
    private ListNode tail;

    private int length;

    public int size()
    {
        return length;
    }

    public void prepend(int data)
    {
        length++;
        var newnode=new ListNode(data);
        if(head==null)
        {
            head=tail=newnode;
            return;
        }
        newnode.next=head;
        head.prev=newnode;
        head=newnode;

    }

    public void append(int data)
    {
        length++;
        var newnode=new ListNode(data);
        if(head==null)
        {
            head=tail=newnode;
            return;
        }
        newnode.prev=tail;
        tail=tail.next=newnode;
    }

    public void displayForward()
    {
        var curr=head;
        System.out.print("head <->");
        while(curr!=null)
        {
            System.out.print(curr.data);
            System.out.print("<->");
            curr=curr.next;
        }
        System.out.println("tail");
    }

    public void displayBackward()
    {
        var curr=tail;
        System.out.println("tail<->");
        while(curr!=null)
        {
            System.out.print(curr.data);
            System.out.print("<->");
            curr=curr.prev;
        }

        System.out.println("head");
    }

    public int deleteFirst() throws NoSuchElementException{
        if(head==null)
        {
            throw new NoSuchElementException("list is empty");
        }
        length--;
        if(head==tail)
        {
            int data=head.data;
            head=tail=null;
            return data;
        }

        var nodetodelete=head;
        head=head.next;
        head.prev=null;
        nodetodelete.next=null;
        return nodetodelete.data;
    }

    public int deleteLast() throws NoSuchElementException{
        if(head==null)
        {
            throw new NoSuchElementException("list is empty");
        }
        length--;
        if(head==tail)
        {
            int data=tail.data;
            head=tail=null;
            return data;
        }

        var nodetodelete=tail;
        tail=tail.prev;
        nodetodelete.prev=null;
        return nodetodelete.data;
    }

    public int inserAtGivenIndex(int data,int index)
    {
        if(head==null && index!=0)
        {
            System.out.println("list is empty.node can only added at index 0");
        }
        int count=0;
        var curr=head;
        var newnode=new ListNode(data);
        while(curr!=null)
        {
            curr=curr.next;
            count++;
            if(count==index-1)
            {
                curr.next=newnode;
                newnode.prev=curr;
                curr.next.next=newnode.next;
                newnode.next.prev=newnode;
            }
        }
        return newnode.data;
    }

    public int deleteAtGivenIndex(int data,int index)
    {
        if(head==null)
        {
            System.out.println("list is empty");
        }

        int count=0;
        var curr=head;

        while(curr!=null)
        {
            curr=curr.next;
            count++;
            if(count==index)
            {
                curr.prev.next=curr.next.next;
                curr.next.next.prev=curr.prev.prev;
            }
        }

        return data;
    }

    public static void main(String[] args) {

        DLL list = new DLL();

        // let's populate the list with some initial values
        Stream.of(19, 49, 13, 59, 333, 283, 293, 100).forEach(list::append);
         Scanner sc=new Scanner(System.in);
        the_loop:
        while (true) {
            list.displayForward();
            list.displayBackward();

            System.out.println("\n*** Main Menu ***");
            System.out.println("0. Exit");
            System.out.println("1. Prepend");
            System.out.println("2. Append");
            System.out.println("3. Size");
            // todo: assignment tasks
            System.out.println("4. Search");
            System.out.println("5. Delete the first element");
            System.out.println("6. Delete the last element");
            System.out.println("7. Insert data at a given index");
            System.out.println("8. Delete data at a given index");

            int choice;

            try {
                System.out.println("enter choice : ");
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
                    try {
                        System.out.println("enter data : ");
                        int data=sc.nextInt();
                        if (choice == 1) {
                            list.prepend(data);
                        } else if (choice == 2) {
                            list.append(data);
                        }
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
                default:
                    System.out.println("Invalid choice. Please try again.");
            }


        }
    }

}