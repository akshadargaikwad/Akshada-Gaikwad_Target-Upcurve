package com.sortinglibrary;

public interface Sortable {

    void sort(int[] arr);
}

class BubbleSort implements Sortable{
    @Override
    public void sort(int[] arr) {
        int n=arr.length;
        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }


    }


}
class SelectionSort implements Sortable{
    @Override
    public void sort(int[] arr) {
        int n=arr.length;
        for(int i=0;i<n-1;i++)
        {
            int minindex=i;
            for(int j=i+1;j<n;j++)
            {
                if(arr[j]<arr[minindex])
                {
                    minindex=j;
                }
            }
            int temp=arr[minindex];
            arr[minindex]=arr[i];
            arr[i]=temp;
        }
    }



}

class MergeSort implements Sortable{
   public void sort(int[] arr)
   {
       mergeSort(arr,0,arr.length-1);
   }

   private void mergeSort(int[] arr,int left,int right)
   {
       if(left<right)
       {
           int mid=(left+right)/2;
           mergeSort(arr,left,mid);
           mergeSort(arr,mid+1,right);
           merge(arr,left,mid,right);
       }
   }

   private void merge(int[] arr,int left,int mid,int right)
   {
       int n1=mid-left+1;
       int n2=right-mid;

       int[] L=new int[n1];
       int[] R=new int[n2];

       for(int i=0;i<n1;i++)
       {
           L[i]=arr[left+i];
       }

       for(int j=0;j<n1;j++)
       {
           R[j]=arr[mid+1+j];
       }

       int i=0;
       int j=0;
       int k=left;
       while(i<n1 && j<n2)
       {
           if(L[i]<=R[j])
           {
               arr[k]=L[j];
               i++;
           }
           else{
               arr[k]=R[j];
               j++;
           }

           k++;
       }

       while(i<n1)
       {
           arr[k]=L[i];
           i++;
           k++;
       }

       while(i<n2)
       {
           arr[k]=R[j];
           j++;
           k++;
       }
   }

}

class Sorter{
    public void sort(Sortable algorithm,int[]arr)
    {
        algorithm.sort(arr);
    }
}

public class SortingTest{
    public static void main(String[] args)
    {
        int[] arr1={5,2,9,1,7};
        int[] arr2={8, 3, 6, 4, 2};
        int[] arr3 = {10, 6, 3, 8, 1};

        Sorter sorter=new Sorter();

        BubbleSort bubblesort=new BubbleSort();
        sorter.sort(bubblesort,arr1.clone());
        System.out.println("using bubble sort : ");
        printArray(arr1);

        // Using Selection Sort
        SelectionSort selectionSort = new SelectionSort();
        sorter.sort(selectionSort, arr2.clone());
        System.out.println("Using Selection Sort:");
        printArray(arr2);

        // Using Merge Sort
        MergeSort mergeSort = new MergeSort();
        sorter.sort(mergeSort, arr3.clone());
        System.out.println("Using Merge Sort:");
        printArray(arr3);
    }

    private static void printArray(int[] arr) {
        System.out.print("Original array: ");
        System.out.print(Arrays.toString(arr));
        System.out.print(" Sorted array: ");
        System.out.println(Arrays.toString(arr));
    }
}
    }
}




