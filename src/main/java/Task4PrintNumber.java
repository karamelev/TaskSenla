import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task4PrintNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number");
        String number = scan.nextLine();
        System.out.println("Enter pattern ");
        String pattern = scan.nextLine();
        printNumber(number, pattern);
    }
    public static int[][] one = {{0, 0, 1}, {0, 1, 1}, {1, 0, 1}, {0, 0, 1}, {0, 0, 1}, {0, 0, 1}};
    public static int[][] two = {{1, 1, 1}, {1, 0, 1}, {0, 0, 1}, {0, 1, 0}, {1, 0, 0}, {1, 1, 1}};
    public static int[][] three = {{1, 1, 1}, {0, 0, 1}, {0, 1, 1}, {0, 0, 1}, {0, 0, 1}, {1, 1, 1}};
    public static int[][] four = {{1, 0, 1}, {1, 0, 1}, {1, 0, 1}, {1, 1, 1}, {0, 0, 1}, {0, 0, 1}};
    public static int[][] five = {{1, 1, 1}, {1, 0, 0}, {1, 1, 1}, {0, 0, 1}, {0, 0, 1}, {1, 1, 1}};
    public static int[][] sex = {{0, 0, 1}, {0, 1, 0}, {1, 0, 0}, {1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
    public static int[][] seven = {{1, 1, 1}, {0, 0, 1}, {0, 0, 1}, {0, 1, 0}, {1, 0, 0}, {1, 0, 0}};
    public static int[][] eight = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}, {1, 0, 1}, {1, 0, 1}, {1, 1, 1}};
    public static int[][] nine = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}, {0, 0, 1}, {0, 1, 0}, {1, 0, 0}};
    public static int[][] zero = {{1, 1, 1}, {1, 0, 1}, {1, 0, 1}, {1, 0, 1}, {1, 0, 1}, {1, 1, 1}};


    private static int[][] getNumber(String digit) {
        int[][] number;
        switch (digit) {
            case "1":
                number = one;
                break;
            case "2":
                number = two;
                break;
            case "3":
                number = three;
                break;
            case "4":
                number = four;
                break;
            case "5":
                number = five;
                break;
            case "6":
                number = sex;
                break;
            case "7":
                number = seven;
                break;
            case "8":
                number = eight;
                break;
            case "9":
                number = nine;
                break;
            case "0":
                number = zero;
                break;
            default:
                throw new IllegalArgumentException("Not correct digit");
        }
        return number;
    }

    public static void printNumber(String number, String pattern) {
        ArrayList<int[][]> digits = new ArrayList<>();
        String[] numberToArray = number.split("");

        for (String num : numberToArray) {
            digits.add(getNumber(num));
        }
        String emptySpace = "";
        for (int i = 0; i < pattern.length(); i++) {
            emptySpace += " ";
        }

        for (int i = 0; i < digits.get(0).length; i++) {
            for (int[][] digit : digits) {
                for (int j = 0; j < digit[i].length; j++) {
                    System.out.print(digit[i][j] == 0 ? emptySpace : pattern);
                }
                System.out.print("  ");
            }
            System.out.println();
        }
    }
}

