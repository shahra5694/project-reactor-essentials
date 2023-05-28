package algoritham;

public class fibonacciNumber {

    static int makeFibonacciNumber(int n) {
        if(n<=1) {
            return n;
        }
        return makeFibonacciNumber(n-1)+makeFibonacciNumber(n-2);
    }

    public static void main(String[] args) {
        int n=8;
        for(int i=0;i<n;i++)
          System.out.print(makeFibonacciNumber(i)+" ");
    }
}
