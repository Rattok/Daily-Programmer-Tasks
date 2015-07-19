package Pangrams;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Pangrams {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        for (int i = 0, n = in.nextInt(); i < n; ++i) {
            if (i == 0) in.nextLine();
            Set<Character> uniq = new HashSet<>();
            for (char c : in.nextLine().toLowerCase().replaceAll("[^a-z]", "").toCharArray()) uniq.add(c);
            System.out.println(uniq.size() == 26 ? "True" : "False");
        }

    }
}
