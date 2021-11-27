package hard;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 *
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.
 *
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 * Implement the MedianFinder class:
 *
 * MedianFinder() initializes the MedianFinder object.
 * void addNum(int num) adds the integer num from the data stream to the data structure.
 * double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 */
public class Find_Median_from_Data_Stream {
    class MedianFinder {
        Queue<Integer> small;
        Queue<Integer> large;
        boolean even;

        public MedianFinder() {
            small = new PriorityQueue<>(Collections.reverseOrder());
            large = new PriorityQueue<>();
            even = true;
        }

        public void addNum(int num) {
            if (even) {
                large.add(num);
                small.add(large.poll());
            } else {
                small.add(num);
                large.add(small.poll());
            }
            even = !even;
        }

        public double findMedian() {
            if (even) {
                return (small.peek() + large.peek()) / 2.0;
            } else {
                return small.peek() * 1.0;
            }
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
