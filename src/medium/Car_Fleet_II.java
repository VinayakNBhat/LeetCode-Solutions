package medium;

import java.util.Stack;

/**
 * https://leetcode.com/problems/car-fleet-ii/
 *
 * There are n cars traveling at different speeds in the same direction along a one-lane road. You are given an array cars of length n, where cars[i] = [positioni, speedi] represents:
 *
 * positioni is the distance between the ith car and the beginning of the road in meters. It is guaranteed that positioni < positioni+1.
 * speedi is the initial speed of the ith car in meters per second.
 * For simplicity, cars can be considered as points moving along the number line. Two cars collide when they occupy the same position. Once a car collides with another car, they unite and form a single car fleet. The cars in the formed fleet will have the same position and the same speed, which is the initial speed of the slowest car in the fleet.
 *
 * Return an array answer, where answer[i] is the time, in seconds, at which the ith car collides with the next car, or -1 if the car does not collide with the next car. Answers within 10-5 of the actual answers are accepted.
 *
 *
 * TC: O(N)
 * SC: O(N)
 */
public class Car_Fleet_II {
    class Solution {
        public double[] getCollisionTimes(int[][] cars) {
            int n = cars.length;
            Stack<Integer> stack = new Stack<>();
            double[] res = new double[n];

            for(int i = n-1; i >= 0; i--) {
                while(!stack.isEmpty() && cars[i][1] <= cars[stack.peek()][1]) {
                    stack.pop();
                }

                while(!stack.isEmpty()) {
                    double collisionTime = (cars[stack.peek()][0] - cars[i][0]) * 1.0 / (cars[i][1] - cars[stack.peek()][1]);
                    if(collisionTime <= res[stack.peek()] || res[stack.peek()] == -1) {
                        res[i] = collisionTime;
                        break;
                    }
                    stack.pop();
                }

                if(stack.isEmpty()) {
                    res[i] = -1.00000;
                }

                stack.push(i);
            }

            return res;
        }
    }
}
