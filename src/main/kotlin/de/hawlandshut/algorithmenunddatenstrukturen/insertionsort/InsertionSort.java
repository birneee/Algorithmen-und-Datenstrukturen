package de.hawlandshut.algorithmenunddatenstrukturen.insertionsort;

import java.util.List;

public class InsertionSort
{
    /* Function to sort an array using insertion sort*/
    public static void insertionSort(int arr[], int n)
    {
        int i, key, j;
        for (i = 1; i < n; i++)
        {
            key = arr[i];
            j = i-1;

       /* Move elements of arr[0..i-1], that are
          greater than key, to one position ahead
          of their current position */
            while (j >= 0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }

    public static void insertionSort(List<Integer> list)
    {
        int key, j;
        for(int i = 1; i < list.size();i++)
        {
            key = list.get(i);
            j = i -1;

            while(j >=0 && list.get(j) > key)
            {
                list.set(j+1,list.get(j));
                j--;
            }
            list.set(j+1,key);
        }
    }




    static public void shift(int a,int b,List<Integer> list)
    {
        int tmp = list.indexOf(a);
        while(a > b)
        {
            list.set(a,list.indexOf(a-1));
            a--;
        }
        list.set(b,tmp);
    }
}
