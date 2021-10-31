package dp;

public class Maximum_SubArray {
    public static int maxSubArraySum(int[] arr) {

        int size = arr.length;
        int start = 0;
        int end = 0;

        int maxSoFar = arr[0], maxEndingHere = arr[0];

        for (int i = 0; i < size; i++) {
            if (arr[i] > maxEndingHere + arr[i]) {
                start = i;
                maxEndingHere = arr[i];
            } else
                maxEndingHere = maxEndingHere + arr[i];

            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                end = i;
            }
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        maxSubArraySum(new int[]{1,-4,5,6,6,-3,5,6});
    }
}
