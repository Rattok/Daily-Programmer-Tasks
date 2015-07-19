package GreatestCommonDivisor;

import java.math.BigInteger;
import java.util.Scanner;

public class GreatestCommonDivisor {

    public static void main(String args[]){
        boolean loop = true;
        while(loop) {
            String[] userInput = new Scanner(System.in).nextLine().split(" ");
            long a = Long.valueOf(userInput[0]);
            long b = Long.valueOf(userInput[1]);

            while (a != b) {
                if (a > b)
                    a -= b;
                else
                    b -= a;
            }

            System.out.println(a);
        }
    }
}
