import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3SortVowel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter string: ");
        String str = scanner.nextLine();
        String regex = "[ауоыиэяюёеАУОЫИЗЯЮЁЕ]";
        Pattern pattern = Pattern.compile(regex);

        String [] arrayWord = str.split(" ");
        int [] amountOfVowel = new int [arrayWord.length];

        for (int i = 0; i < arrayWord.length; i++) {
            int count = 0;
            String [] letters = arrayWord[i].split("");
            for (int j = 0; j < letters.length; j++) {
                Matcher matcher = pattern.matcher(letters[j]);
                if (matcher.find()) {
                    count ++;
                    if (count == 1) {
                        letters[j] = letters[j].toUpperCase();
                    }
                }
            }
            arrayWord[i] = String.join("", letters);
            amountOfVowel[i] = count;
        }
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < amountOfVowel.length; i++) {
                if (amountOfVowel[i] > amountOfVowel[i-1]) {
                    int bufferInt = amountOfVowel[i];
                    amountOfVowel[i] = amountOfVowel[i-1];
                    amountOfVowel[i-1] = bufferInt;
                    String bufferString = arrayWord[i];
                    arrayWord[i] = arrayWord[i-1];
                    arrayWord[i-1] = bufferString;
                    isSorted = false;
                }
            }
        }
        for (int i = 0; i < arrayWord.length; i++) {
            System.out.println(arrayWord[i] + " - " + amountOfVowel[i] + " гласных букв");
        }
    }
}
