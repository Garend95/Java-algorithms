import java.util.Scanner;

public class RodCutting {
    public static void Main(String[] args) {
        int cost[] = new int[1000];
        int d[] = new int[1000];
        int max_index[] = new int[1000];
        int n;

        RodCutting R = new RodCutting();
        Scanner input = new Scanner(System.in);

        n = input.nextInt();
        for(int i = 1; i <= n; i++) {
            cost[i] = input.nextInt();
        }
        d[1] = cost[1];
        for (int i = 2; i <= n; i++) {
            d[i] = cost[i];
            max_index[i] = 0;
            for (int j = 2; j <= i / 2; j++) {
                if (d[i] < d[j] + d[i - j]) {
                    max_index[i] = j;
                    d[i] = d[j] + d[i - j];
                }
            }
        }
        System.out.println(d[n]);
        R.print(n, max_index);
    }

    private void print(int n, int[] max_index) {
        if (max_index[n] == 0) {
            System.out.print(n + " ");
            return;
        }
        print(max_index[n], max_index);
        print(n - max_index[n], max_index);
    }
}
