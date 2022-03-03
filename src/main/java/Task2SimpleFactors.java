import java.util.Arrays;
import java.util.Scanner;

public class Task2SimpleFactors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number to be factored.");
        int n = scanner.nextInt();
        int b = 2;
        if (n % 2 == 0) {
        while (n != 1) {
            if (n % b == 0) {
                System.out.print(b + " ");
                n /= b;
            } else if (b == 2) {
                b++;
            } else {
                b += 2;
            }
        }
    } else {
            System.out.println("integer");
        }
    }
}
