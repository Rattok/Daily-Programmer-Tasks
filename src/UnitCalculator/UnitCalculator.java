package UnitCalculator;

import com.sun.javafx.scene.layout.region.Margins;

import java.util.Scanner;

public class UnitCalculator {

    private static String[][] conversionRate = {{"Metres to inches" , "39.3700787"}, {"Metres to miles", "0.000621371192"}, {"Centimetres to attoparsecs", "0.324077929"}};

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        String[] word = userInput.split(" ");
        System.out.println(word[0] + word[1] + word[2] + word[3]);

        System.out.println(calculateUnit(Double.parseDouble(word[0]), word[1], word[3]));
    }

    public static double calculateUnit(double amount, String oldUnit, String newUnit) {
        double result = 0;
        String conversion = oldUnit.toLowerCase() + " to " + newUnit.toLowerCase();
        switch(conversion) {

            case "metres to inches":            return (result = (amount * 39.3700787));
            case "inches to metres":            return (result = (amount / 39.3700787));
            case "metres to miles":             return (result = (amount * 0.000621371192));
            case "miles to metres":             return (result = (amount / 0.000621371192));
            case "centimetres to attoparsecs":  return (result = (amount * 0.324077929));
            case "attoparsecs to centimetres":  return (result = (amount / 0.324077929));


        }


        return result;
    }
}
