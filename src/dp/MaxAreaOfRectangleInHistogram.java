package dp;

import java.util.Stack;

public class MaxAreaOfRectangleInHistogram {
    public static void main(String[] args) {
        //int[] nums = {2, 1, 2, 3};
        //int[] nums = {2, 1, 2};
        int[] nums = {6, 2, 5, 4, 5, 1, 6};

        Stack<Integer> stack = new Stack<>();

        int maxArea = -1;
        int i = 0;

        for(; i < nums.length;) {
            if (stack.isEmpty() || nums[stack.peek()] < nums[i]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    maxArea = Math.max(maxArea, nums[top] * i);
                } else {
                    maxArea = Math.max(maxArea, nums[top] * (i - stack.peek() - 1));
                }
            }
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (stack.isEmpty()) {
                maxArea = Math.max(maxArea, nums[top] * i);
            } else {
                maxArea = Math.max(maxArea, nums[top] * (i - stack.peek() - 1));
            }
        }

        System.out.print("Max area = " + maxArea);

    }
}
