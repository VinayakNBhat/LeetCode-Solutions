package dp.knapsack;

public class Knapsack_0_1_Recursive {
    public static void main(String[] args) {
        int[] wt = {1,3,4,5}; //{10,20,30};
        int[] val = {1,4,5,7};//{60,100,120};
        int W = 7; //50;

        System.out.print(getMaximisedOp(wt, val, W, wt.length - 1));
    }

    static int getMaximisedOp(int[] wt, int[] val, int W, int index) {
        if(index < 0 || W <= 0) return 0;

        if (wt[index] > W) return getMaximisedOp(wt, val, W, index - 1);

        return Math.max(val[index] + getMaximisedOp(wt, val, W - wt[index], index - 1), getMaximisedOp(wt, val, W, index - 1));
    }
}
