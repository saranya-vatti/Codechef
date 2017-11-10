package com.company;
import java.util.*;
public class Solution {
    private static int MAX_A = 27;
    private static int MAX_N = 100001;
    private static String[][] result = new String[MAX_A][MAX_N];
    private static int[][] palinLen = new int[MAX_A][MAX_N];
    private static void compute(int A, int N) {
        if(palinLen[A-1][N] == -1) compute(A-1, N);
        if(palinLen[A][N-1] == -1) compute(A, N-1);
        // result[A][N] = min{result[A-1][N], result[A][N-1]+(Take any of the first
        // A char of alpha and add it to the N-1'th string),
        // result[A-1][N]+(replace one or more
        // letters in the string result [A-1][N-1] with Ath char of the alphabet)
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for(int i=0;i<palinLen.length;i++) {
            for(int j=0;j<palinLen[i].length;j++) {
                if(i==0) {
                    result[i][j] = "";
                    palinLen[i][j] = 0;
                } else if(i>=j) {
                    palinLen[i][j] = 1;
                    StringBuilder str = new StringBuilder("");
                    for(int k=0;k<j;k++) {
                        str.append((char)('a'+i));
                    }
                    result[i][j] = str.toString();
                } else {
                    palinLen[i][j]=-1;
                }
            }
        }
        while(T-->0) {
            int N = s.nextInt();
            int A = s.nextInt();
            if(palinLen[A][N] == -1) {
                compute(A, N);
            }
            System.out.println(palinLen[A][N] + " " + result[A][N]);
        }
    }
}
