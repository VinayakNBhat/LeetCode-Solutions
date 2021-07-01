package medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/car-fleet/
 *
 * N cars are going to the same destination along a one lane road.  The destination is target miles away.
 *
 * Each car i has a constant speed speed[i] (in miles per hour), and initial position position[i] miles towards the target along the road.
 *
 * A car can never pass another car ahead of it, but it can catch up to it, and drive bumper to bumper at the same speed.
 *
 * The distance between these two cars is ignored - they are assumed to have the same position.
 *
 * A car fleet is some non-empty set of cars driving at the same position and same speed.  Note that a single car is also a car fleet.
 *
 * If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.
 *
 *
 * How many car fleets will arrive at the destination?
 *
 * TC: O(NlogN)
 * SC: O(N)
 */
public class Car_Fleet {
    class Solution {
        class Car {
            int position;
            double tTT;

            public Car(int position, double tTT) {
                this.position = position;
                this.tTT = tTT;
            }
        }

        public int carFleet(int target, int[] position, int[] speed) {
            int n = position.length;

            if(n <= 1) return n;

            Car[] car = new Car[n];

            for(int i = 0; i < n; i++) {
                car[i] = new Car(position[i], (target - position[i]) * 1.0 / speed[i]);
            }

            Arrays.sort(car, new Comparator<Car>() {
                public int compare(Car a, Car b) {
                    return a.position - b.position;
                }
            });

            int fleet = 1;
            for(int i = n-1; i >= 1; i--) {
                if(car[i-1].tTT <= car[i].tTT) {
                    car[i-1].tTT = car[i].tTT;
                } else {
                    fleet++;
                }
            }

            return fleet;
        }
    }
}
