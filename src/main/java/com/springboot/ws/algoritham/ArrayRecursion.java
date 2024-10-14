package com.springboot.ws.algoritham;

public class ArrayRecursion {

    public static void main(String[] args) {
        int arr [] = new int[] {1,2,3,4,5,6,7};
        recursiveArray(arr,0,arr.length-1);
        for (int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");

        System.out.println("\n----------------------");
        recursiveArrayWithHalfLengthTravers(arr,0, arr.length);
        for (int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }


    /***************************************************************************************************************/

    static void recursiveArray(int [] arr, int i, int r) {
        if(i>=r)
            return;
        swap(arr,i,r);
        recursiveArray(arr,i+1,r-1);
    }

    private static void swap(int[] arr, int i, int r) {
        int temp = arr[i];
        arr[i]=arr[r];
        arr[r]=temp;
    }

    /***************************************************************************************************************/

    static void recursiveArrayWithHalfLengthTravers(int arr[], int i, int n) {
        if(i>=(n/2))
            return;
        swap(arr,i,n-1-i);
        recursiveArrayWithHalfLengthTravers(arr,i+1,n);
    }

}
