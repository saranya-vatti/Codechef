package com.company;
import java.util.*;
public class Solution {
    private static int fact(int n) {
        if(n<=1) return 1;
        return n*fact(n-1);
    }
    private static int perm(int n, int r) {
        return fact(n)/(fact(r) * fact(n-r));
    }
    private static int startWithDishes(int activities, int dishes, int hoursLeft) {
        if(hoursLeft <= 1) {
            return dishes;
        }
        int result = dishes * totalways(activities, dishes, hoursLeft -
                1);
        /*System.out.printf("Number of ways to choose from %s activities and %s " +
                        "dishes" +
                        " while starting with a dish, in %s hours is %s\n", activities, dishes,
                hoursLeft, result);*/
        return result;
    }
    private static int totalways(int activities, int dishes, int hoursLeft) {
        if (hoursLeft <= 1) {
            return activities + dishes + 1;
        }
        int ifActChosen = activities * totalways(activities, dishes,
                hoursLeft - 1);
        int ifDishChosen = (dishes * totalways(activities, dishes,
                hoursLeft - 1)) - startWithDishes(activities, dishes, hoursLeft -
                1);
        /*System.out.printf("Total number of valid ways to choose from %s " +
                        "activities and %s dishes in %s hours is %s\n", activities,
                dishes,
                hoursLeft, ifActChosen + ifDishChosen + 1);*/
        return ifActChosen + ifDishChosen;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int K = in.nextInt();
        int A = in.nextInt();
        int P = in.nextInt();
        int Q = in.nextInt();
        while (Q-->0) {
            int L = in.nextInt();
            int D = in.nextInt();
            int T = in.nextInt();
            int sum = 0;
            int day = 0;
            while(day<T) {
                D = D + day;
                if(K == 1) {
                    sum = sum + perm(D, L);
                } else if(K==2) {
                    sum = sum + (perm(D, L)*A);
                    //} else if(K==3) {
                    //    sum = sum + (perm(D, L)*A*(D+A));
                } else {
                    sum = sum + ((perm(D, L) * (totalways(A, D, K - 1) -
                            startWithDishes(A, D, K - 1))));
                }
                day++;
            }
            System.out.println((sum-1)%P);
        }
    }
}
