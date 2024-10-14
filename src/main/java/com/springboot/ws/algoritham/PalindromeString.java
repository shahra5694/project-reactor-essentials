package com.springboot.ws.algoritham;

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
        System.out.println(pal(ch,0,ch.length-1));
//        System.out.println(palindrome(ch,0,ch.length));
    }

    public static boolean pal(char[] ch, int l, int r) {
        if(l>=r) {
            return true;
        }
        if(ch[l] != ch[r]) {
            return false;
        }
       return pal(ch,l+1, r-1);
    }
}
