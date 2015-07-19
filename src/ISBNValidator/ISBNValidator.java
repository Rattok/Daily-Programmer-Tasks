package ISBNValidator;


import java.util.ArrayList;
import java.util.Scanner;

public class ISBNValidator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String numbers = input.replace("-", "");
        ArrayList<Integer> numberList = new ArrayList<>();
        char[] numberArray = numbers.toCharArray();

        for(int i = 0; i<numbers.length(); i++) {
            int number = Character.getNumericValue(numberArray[i]);
            numberList.add(number);
        }
        System.out.println(calculateSum(numberList));
        if((calculateSum(numberList) % 11) == 0) { System.out.println("The ISBN Code " + input + " is valid!"); }
        else { System.out.println("The ISBN Code " + input + " is NOT valid!"); }
    }

    public static int calculateSum(ArrayList<Integer> numbers) {
       int sum = 0;

        for(int i = 10, c = 0; c<numbers.size();i--, c++) {
            sum += i * numbers.get(c);
        }
        return sum;
    }
}
