package com.company;
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-->0) {
            int N = in.nextInt();
            int P = in.nextInt();
            StringBuilder result = new StringBuilder("");
            if (P<=2) {
                System.out.println("impossible");
            } else {
                StringBuilder strP = new StringBuilder("a");

                while(strP.length()*2<P-2) {
                    strP.append(strP);
                }
                if (strP.length() < P-2) {
                    while(strP.length()<P-2) {
                        strP.append("a");
                    }
                }
                strP.append("b");
                strP.append(strP);
                strP.append("b");
                result.append(strP);
                // System.out.println("strP = "+strP);
                while(result.length()*2<N) {
                    result.append(result);
                }
                while(result.length()<N) {
                    result.append(strP);
                }
                System.out.println(result);
            }
        }
    }
}
