package com.company;
import java.util.*;
/*
...
...A
...A...
...B
...B...
A...
B...
...B...B...B..
..A...A..A
AABAABB
A..A..B...B
..A..
A....A
..B..B..B..
.A..B..A..B..A..A...
.BBBABA
AAA
B.AA..A.BABA
.ABA.AB..
A.AAABBAA.B.
...A..BBBB...A
.BB.
BABB..BBB.A.
.BAA
A.
.A.BBB..AAB.BAA
.BAAAABA
BB
A.
.A.BA..BAABAA
BB.BBA...AB...
AA..A.A.BAAAA
BBB....A.A.
B..B.A..AAAAA
B.A.A.ABAAA.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-->0) {
            String s = in.next();
            if(s.indexOf('A') == -1) {
                if(s.indexOf('B') == -1) {
                    System.out.println("0 0");
                } else {
                    System.out.println("0 " + (s.lastIndexOf('B') - s.indexOf('B')
                            + 1));
                }
            } else if(s.indexOf('B') == -1) {
                System.out.println((s.lastIndexOf('A') - s.indexOf('A')
                        + 1) + " 0");
            } else {
                int[] answer = {0,0};
                char prev = '.';
                int start = Math.min(s.indexOf('A'), s.indexOf('B'));
                int last = Math.max(s.lastIndexOf('A'), s.lastIndexOf('B'));
                char runningCounter = '.';
                for(int i=start;i<=last;) {
                    if (s.charAt(i) == 'A') {
                        answer[0]++;
                        prev = 'A';
                        i++;
                    } else if (s.charAt(i) == 'B') {
                        answer[1]++;
                        prev = 'B';
                        i++;
                    } else {
                        int count = 0;
                        while (i<=last && s.charAt(i) == '.') {
                            i++;
                            count++;
                        }
                        if (s.charAt(i) == prev) {
                            answer[prev - 'A']+=count;
                        }
                    }
                }
                System.out.println(answer[0] + " " + answer[1]);
            }
        }
    }
}
 