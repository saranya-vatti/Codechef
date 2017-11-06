package com.company;
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-->0) {
            int N = in.nextInt();
            int P = in.nextInt();
            String str = "";
            if (P<=2) {
                System.out.println("impossible");
            } else {
                String strP = "a";

                while(strP.length()*2<P-2) {
                    strP += strP;
                }
                if (strP.length() < P-2) {
                    while(strP.length()<P-2) {
                        strP += "a";
                    }
                }
                strP = "b" + strP + "b";
                str = strP;
                // System.out.println("strP = "+strP);
                while(str.length()*2<N) {
                    str += str;
                }
                if (str.length() < N) {
                    while(str.length()<N) {
                        str += strP;
                    }
                }
                System.out.println(str);
            }
        }
    }
}
 