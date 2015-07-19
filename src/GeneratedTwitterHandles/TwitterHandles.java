package GeneratedTwitterHandles;

import com.sun.image.codec.jpeg.TruncatedFileException;
import com.sun.javaws.jnl.LibraryDesc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class TwitterHandles  {


/* Doesn't sort correctly

 */


    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> wordList = new ArrayList<>();
        ArrayList<String> shortestTruncList = new ArrayList<>();


        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/Paul/IdeaProjects/Daily Programmer Tasks/src/enable1.txt"))) {

            String line = br.readLine();

            while (line != null) {
                line = br.readLine();
                wordList.add(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i = 0; i<wordList.size()-1;i++) {
            String originalWord = wordList.get(i);
            if(originalWord.contains("at")) {
                String truncWord = originalWord.replace("at", "@");
                shortestTruncList.add(truncWord);
                System.out.println(truncWord);
            }
        }
        System.out.println("This is after everything...");
        Thread.sleep(3000);
        sortListShort(shortestTruncList);
        sortListLong(shortestTruncList);
    }



    public static void sortListShort(ArrayList<String> wordList) {
        Collections.sort(wordList, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });

        for(int i = 0; i<10; i++) {
            String origWord = wordList.get(i).replace("@", "at");
            System.out.println(wordList.get(i) + " : " + origWord );
        }
    }

    public static void sortListLong(ArrayList<String> wordList) {

        Comparator comp = Collections.reverseOrder();
        Collections.sort(wordList, comp);

        for(int i = 0; i<10; i++) {
            String origWord = wordList.get(i).replace("@", "at");
            System.out.println(wordList.get(i) + " : " + origWord );
        }
    }


}
