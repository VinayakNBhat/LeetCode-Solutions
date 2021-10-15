package dp.knapsack;

import java.util.Arrays;

public class Knapsack_0_1 {
    public static void main(String[] args) {
        int[] wt = {1,3,4,5}; //{10,20,30};
        int[] val = {1,4,5,7};//{60,100,120};
        int W = 7; //50;

        int n = wt.length;

        int max = Arrays.stream(wt).max().getAsInt();

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i != j) {
                    int weight = wt[i] + wt[j];
                    if(weight <= W) {
                        int totalSum = val[i] + val[j];
                        max = Math.max(max, totalSum);
                    }
                }
            }
        }


        System.out.print("Maximised sum = " + max);
    }


}
