package MergeSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MergeSort {

    static List listA = new ArrayList<Integer>();
    static List listB = new ArrayList<Integer>();

    public static void main(String[] args) {
        String[] listInputA = new Scanner(System.in).nextLine().split(" ");
        String[] listInputB = new Scanner(System.in).nextLine().split(" ");
        for(int i = 0; i < listInputA.length; i++) {
            listA.add(Integer.valueOf(listInputA[i]));
        }
        for(int i = 0; i < listInputB.length; i++) {
            listB.add(Integer.valueOf(listInputB[i]));
        }

        System.out.println(listA);
        System.out.println(listB);
        mergeLists(listA,listB);
        System.out.println(listA);
        System.out.println(listB);
    }

    public static void mergeLists(List listA, List listB) {

        for(int i = 0; i<listA.size()-1;i++) {
            listB.add(listA.get(i));
        }
        sortList(listB);
    }

    public static void sortList(List listB) {
        Collections.sort(listB);
    }
}
