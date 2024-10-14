import java.util.HashSet;
import java.util.Set;

public class DuplicateElementWithinKDistanceInArray {

    public static void main(String[] args) {
        int arr[] = { 10, 5, 3, 4, 3, 5, 6 };
        if (checkDuplicatesWithinK(arr, 3))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    static boolean checkDuplicatesWithinK(int [] ar, int k){
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<ar.length;i++) {
            if (set.contains(ar[i])) {
                return true;
            }
            set.add(ar[i]);
           if(i>=k) {
               set.remove(ar[i-k]);
           }
        }
        return false;
    }
}
