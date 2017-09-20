import java.util.Scanner;

public class Knapsack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Knapsack k = new Knapsack();
        int a[] = new int[1000];
        int D[][] = new int[1000][10000];
        int n, M;

        n = input.nextInt();
        M = input.nextInt();

        for (int i = 0; i < n; i++)
            a[i] = input.nextInt();

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= M; j++) {
                if (j - a[i] >= 0)
                    D[i][j] = Math.max(D[i - 1][j], D[i - 1][j - a[i]] + a[i]);
                else
                    D[i][j] = D[i - 1][j];
            }
        }
        //System.out.println(D[n][M]);

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= M; j++) {
                System.out.print(D[i][j] + " ");
            }
            System.out.println();
        }
        k.print(n, M, a, D);
    }

    void print(int n, int M, int[] a, int[][] D) {
        if (n==0)
            return;
        if (D[n][M] == D[n-1][M]) {
            print(n-1, M, a, D);
        } else
        {
            System.out.print(a[n] + ' ');
            print(n-1,M - a[n], a, D);
        }
    }
}
