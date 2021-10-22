package dp;

public class Minimum_Number_Of_Jumps_To_Reach_End_Of_The_Array {
    public static void main(String[] args) {
        int[] arr = {2,3,1,1,2,4,2,0,1,1};
        int[] dp = new int[arr.length];
        int[] index = new int[arr.length];

        index[0] = -1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] >= (i - j)) {
                    if (dp[i] == 0) {
                        dp[i] = dp[j] + 1;
                        index[i] = j;
                    } else {
                        if (dp[j] + 1 < dp[i]) {
                            dp[i] = dp[j] + 1;
                            index[i] = j;
                        }
                    }
                }
            }
        }

        System.out.println("Min. number or steps required to reach the end of the array : " + dp[dp.length - 1]);

        System.out.println("Sequence of jumps");
        int j = arr.length - 1;
        System.out.print("{");
        while (j >= 0) {
            System.out.print(j + " ");
            j = index[j];
        }
        System.out.print("}\n");
    }
}
