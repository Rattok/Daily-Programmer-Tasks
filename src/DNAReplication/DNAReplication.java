package DNAReplication;

import java.util.Scanner;

public class DNAReplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        String[] secondDNA = new String[input.length];
        String inputAll = scanner.nextLine().replace(" ", "");

        for(int i = 0; i<input.length;i++) {
            if(input[i].equals("A")) { secondDNA[i] = "T"; }
            if(input[i].equals("T")) { secondDNA[i] = "A"; }
            if(input[i].equals("G")) { secondDNA[i] = "C"; }
            if(input[i].equals("C")) { secondDNA[i] = "G"; }
            System.out.print(secondDNA[i] + " ");
        }


        for(int i = 0; i<inputAll.length()-2; i++) {
            if (inputAll.substring(i, i + 3).equals("ATG")) { System.out.print("Met" + " "); }
            else if(inputAll.substring(i, i + 3).equals("TTT")) { System.out.print("Phe" + " "); }
            else if(inputAll.substring(i, i + 3).equals("CGA")) { System.out.print("Arg" + " "); }
            else if(inputAll.substring(i, i + 3).equals("GGC")) { System.out.print("Gly" + " "); }
            else if(inputAll.substring(i, i + 3).equals("TAA")) { System.out.print("STOP" + " "); }
        }
    }
}
