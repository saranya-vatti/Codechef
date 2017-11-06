package com.company;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        int T = 20; // 20
        int MAXLEN = 100; // 100000
        BufferedWriter writer = new BufferedWriter(new FileWriter
                ("testcases-PERPALIN.txt"));
        String input = T+"\n";
        for(int i=0;i<T;i++) {
            Random rand = new Random();
            int  N = rand.nextInt(MAXLEN) + 1;
            int  P = rand.nextInt(MAXLEN) + 1;
            while(P%N!=0) {
                P = rand.nextInt(MAXLEN) + 1;
            }
            input = input + N + " " + P + "\n";
        }
        writer.write(input);
        writer.close();
    }
}
