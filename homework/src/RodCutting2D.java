import java.util.Scanner;

public class RodCutting2D {
    public static void main(String[] args) {
        int cost[][] = new int[1000][1000];
        int d[][] = new int[1000][1000];
        int cutPrice;

        boolean cut_is_vertical[][] = new boolean[1000][1000];
        int max_index[][] = new int[1000][1000];
        int n, m;

        RodCutting2D R = new RodCutting2D();
        Scanner input = new Scanner(System.in);

        n = input.nextInt();
        m = input.nextInt();
        cutPrice = input.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++){
                cost[i][j] = input.nextInt();
            }
        }
        for (int i = 1; i <= n; i++) {
            d[i][0] = 0;
        }
        for (int j = 1; j <= m; j++) {
            d[0][j] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // Do not cut.
                d[i][j] = cost[i][j];
                max_index[i][j] = 0;

                // Cut horizontally
                for (int k = 1; k <= i / 2; k++) {
                    if (d[i][j] < d[k][j] + d[i - k][j] - cutPrice) {	// comparing entire piece to it being broken into two parts
                        max_index[i][j] = k;
                        cut_is_vertical[i][j] = false;
                        d[i][j] = d[k][j] + d[i - k][j] - cutPrice;
                    }
                }

                // Cut vertically.
                for (int k = 1; k <= j / 2; k++) {	// why the devision by 2 however?
                    if (d[i][j] < d[i][k] + d[i][j - k] - cutPrice) {
                        max_index[i][j] = k;
                        cut_is_vertical[i][j] = true;
                        d[i][j] = d[i][k] + d[i][j - k] - cutPrice;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(d[i][j] + " ");
            }
            System.out.println();
        }

        R.print(n, m);
    }

    private void print(int n, int m) {

    }
}
