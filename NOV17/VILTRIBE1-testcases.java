package com.company;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        int n = 20; // 20
        int MAXLEN = 15; // 100000;
        BufferedWriter writer = new BufferedWriter(new FileWriter
                ("testcases-VILTRIBE.txt"));
        String input = n+"\n";
        char[] possible = {'A', 'B','.'};
        for(int i=0;i<n;i++) {
            Random rand = new Random();
            int  sLen = rand.nextInt(MAXLEN) + 1;
            String s = "";
            for(int index=0;index<sLen;index++) {
                s += possible[rand.nextInt(3)];
            }
            input = input + s + "\n";
        }
        writer.write(input);
        writer.close();
    }
}
