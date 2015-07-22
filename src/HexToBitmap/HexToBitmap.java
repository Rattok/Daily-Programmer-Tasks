package HexToBitmap;

import java.util.Arrays;
import java.util.Scanner;

public class HexToBitmap {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {
            in.forEachRemaining(s -> Arrays.stream(s.split(" "))
                    .map(i -> String.format("%8s", Integer.toBinaryString(Integer.parseInt(i, 16)))
                            .replaceAll("0", " ")
                            .replaceAll("1", "#"))
                    .forEach(System.out::println));
        } catch (Exception e) {}
    }
}
