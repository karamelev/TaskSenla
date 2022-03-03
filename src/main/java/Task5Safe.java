import java.util.ArrayList;
import java.util.Scanner;

public class Task5Safe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите объем сейфа");
        int maxVaultSafe = scanner.nextInt();
        System.out.println("количество предметов ");
        int n = scanner.nextInt();
        int[] vault = new int [n];
        int[] prices = new int [n];

        for (int i = 0; i < n; i++) {
            System.out.println("Введите объем и стоимость предмета: "+(i+1));
            vault [i] = scanner.nextInt();
            prices [i] = scanner.nextInt();

        }

        int count = vault.length;

        int[][] costSafe= new int[count + 1][];;
        for (int i = 0; i < count + 1; i++) {
            costSafe[i] = new int[maxVaultSafe + 1];
        }

        for (int k = 0; k <= count; k++) {
            for (int s = 0; s <= maxVaultSafe; s++) {
                if (k == 0 || s == 0) {
                    costSafe[k][s] = 0;
                } else {
                    if (s >= vault[k - 1]) {
                        costSafe[k][s] = Math.max(costSafe[k - 1][s], costSafe[k - 1][s - vault[k - 1]] + prices[k - 1]);
                    } else {
                        costSafe[k][s] = costSafe[k - 1][s];
                    }
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        traceResult(costSafe, vault, count, maxVaultSafe, result);

        System.out.println("Максимальная ценность сейфа c предмеиами: ");
        for(Integer integer : result) {
            System.out.println(integer);
        }
    }

    private static void traceResult(int[][] costSafe, int[] vault, int k, int s, ArrayList<Integer> result) {
        if (costSafe[k][s] == 0) {
            return;
        }
        if (costSafe[k -1][s] == costSafe[k][s]) {
            traceResult(costSafe, vault, k - 1, s, result);
        } else {
            traceResult(costSafe, vault, k - 1, s - vault[k - 1], result);
            result.add(0, k);
        }
    }
}
