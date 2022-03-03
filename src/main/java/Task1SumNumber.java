import java.util.Scanner;

public class Task1SumNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter string: ");
        String str = scanner.nextLine();
        String [] strArray = str.split("");
        int sum = 0;
        for (String el : strArray) {
            try {
                sum += Integer.parseInt(el);
            }
            catch (Exception error) { }
        }
        System.out.println(sum);
    }
}



