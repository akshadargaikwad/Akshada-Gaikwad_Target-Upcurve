package com.targetindia.search;
import com.targetindia.model.Customer;
import java.util.Arrays;
import com.targetindia.utils.KeyboardUtil;
public class Main {

    public static void main(String[] args) {
        Customer[] customers = Customer.getCustomers();
        Arrays.sort(customers, (c1, c2) -> Integer.compare(c1.id(), c2.id()));

        while (true) {
            System.out.println("main menu");
            System.out.println("0. exit");
            System.out.println("1. display customers");
            System.out.println("2. linear search");
            System.out.println("3. binary search");
            System.out.println("4. jump search");
            System.out.println("5. fibonacci search");

            int choice = KeyboardUtil.getInt("enter your choice");
            if (choice == 0) {
                System.out.println("existing");
                break;
            }
            if (choice < 1 || choice > 5) {
                System.out.println("invalid choice");
                continue;
            }

            if (choice == 1) {
                for (var c : customers) {
                    System.out.println(c);
                }
                continue;
            }
            int id = KeyboardUtil.getInt("enter customer id to search");
            int index = -1;

            if (choice == 2) {
                index = linearSearch(customers, id);
            } else if (choice == 3) {
                index = jumpSearch(customers, id);
            } else {
                index = fibonacciSearch(customers, id);
            }

            if (index == -1) {
                System.out.println("no customer found with id " + id);
            } else {
                var c = customers[index];
                System.out.printf("customers data found at index %d:\n", index);
                System.out.println("Name : " + c.name());
                System.out.println("City : " + c.city());
                System.out.println("Email : " + c.email());
                System.out.println("Phone : " + c.phone());

            }
            System.out.println();
        }
    }

    private static int linearSearch(Customer[] customers,int id)
    {
        for(int index=0;index<customers.length;index++)
        {
            if(customers[index].id()==id)
            {
                return index;
            }
        }

        return -1;
    }


    private static int binarySearch(Customer[] customers,int id)
    {
        int low=0;
        int high=customers.length-1;
        if(customers[low].id()==id)
        {
            return 0;
        }
        if(customers[high].id()==id)
        {
            return high;
        }

        if(id<customers[low].id() || id>customers[high].id())
        {
            return -1;
        }

        int pass=0;
        while(low<=high)
        {
            pass++;
            int mid=(low+high)/2;
            if(id==customers[mid].id())
            {
                System.out.println("pass="+pass);
                return mid;
            }
            else if(id<customers[mid].id())
            {
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }

        System.out.println("pass= "+pass);
        return -1;
    }

    private static int jumpSearch(Customer[] customers,int id)
    {
        int blocksize=(int) Math.sqrt(customers.length);
        int prev=0;
        int curr=blocksize;
        int loopcount=0;
        while(curr<customers.length && customers[curr].id()<=id)
        {
            prev=curr;
            curr+=blocksize;
            loopcount++;
        }

        for (int i = prev; i < Math.min(curr, customers.length); i++) {
            loopcount++;
            if (customers[i].id() == id) {
                System.out.println("loopCount is " + loopcount);
                return i;
            }
        }

        System.out.println("loopCount is " + loopcount);
        return -1;
    }

    public static int fibonacciSearch(Customer[] customers,int id)
    {
        int size=customers.length;
        int a=0;
        int b=1;
        int c=a+b;

        while(c<size)
        {
            a=b;
            b=c;
            c=a+b;
        }

        int offset=-1;
        while(c>1) {
            int i = Math.min(offset + a, size - 1);
            if (customers[i].id() < id) {
                c = b;
                b = a;
                a = c - b;
                offset = i;

            } else if (customers[i].id() > id) {
                c = a;
                b = b - a;
                a = c - b;
            } else {
                return i;
            }
        }

            if(b==1 && customers[size-1].id()==id)
            {
                return size-1;
            }

            return -1;

        }
    }

