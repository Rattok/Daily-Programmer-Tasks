package StringIndex;

public class StringIndex {

    private static String input = "...You...!!!@!3124131212 Hello have this is a --- string Solved !!...? to test @\n\n\n#!#@#@%$**#$@ Congratz this!!!!!!!!!!!!!!!!one ---Problem\n\n";
    private static int[] index = {12, -1, 1, -100, 4, 1000, 9, -1000, 16, 13, 17, 15};

    public static void main(String[] args) {
        String inputWords[] = input.split("[^a-zA-Z0-9]+");

        for (int i : index) {
            if (i > 0 && i  < inputWords.length) {
                System.out.print(inputWords[    i] + " ");
            } else if(i < 0 || i >= inputWords.length) {
                System.out.print("");
            }
        }
    }
}

