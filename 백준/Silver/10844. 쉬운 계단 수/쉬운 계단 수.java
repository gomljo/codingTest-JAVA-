import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int mod = 1_000_000_000;
        int[][] dp = new int[n + 1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {

            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][0] = dp[i-1][1] % mod;
                } else if (j == 9) {
                    dp[i][9] = dp[i - 1][8] % mod;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
                }
            }

        }
        long result = 0;
        for(int i = 0; i < 10; i++) {
            result += dp[n][i];
        }

        System.out.println(result % mod);
    }
}