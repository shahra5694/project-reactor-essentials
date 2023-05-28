public class BinarySearch {

    public static void main(String [] ar) {
        int arr[] = {2, 3, 4, 10, 40, 50, 60, 70};
        System.out.println(binarySearch(arr,4));
    }

     static int searchArray(int[] arr, int key, int low, int high) {
        if (high < low)
        {
            return -1;
        }
        int mid = (high + low) / 2;
        if (arr[mid] == key)
        {
            return  key;
        }
        if (arr[mid] > key)
        {
          return  searchArray(arr, key, low, mid - 1);
        }
        else
        {
           return searchArray(arr, key, mid + 1, high);
        }

    }

    static int binarySearch(int arr[],int key){
        int first = 0;
        int last = arr.length-1;
        int p = -1;
       while(first<=last) {
           int mid = (first+last)/2;
           if(arr[mid]==key) {
                p = mid;
               break;
           }
           if(key > arr[mid])
               first = mid+1;
           else
               last = mid - 1;
       }
       return p;
    }

}
