package algoritham;

public class PalindromeString {

    static boolean palindrome(char [] c, int i, int n) {
        if(i>=(n/2)) {
            return true;
        }
        if(c[i]!=c[n-1-i]) {
            return false;
        }
       return palindrome(c,i+1,n);
    }

    public static void main(String[] args) {
        char[] ch = "madam".toCharArray();
        System.out.println(palindrome(ch,0,ch.length));
    }
}
