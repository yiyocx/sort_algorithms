package com.yiyo.study.stacks_queues;

import java.util.Stack;

public class LargestRectangleHistogram {

    /*
    Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
    find the area of largest rectangle in the histogram.

    Example:
    Given height = [2,1,5,6,2,3], the largest rectangle has area = 10 unit.
     */
    public static void main(String[] args) {
        LargestRectangleHistogram rectangleHistogram = new LargestRectangleHistogram();
        int[] heights = {2, 1, 5, 2, 6, 3};
        int[] heights2 = {2, 1, 5, 6, 2, 3};
        System.out.println(rectangleHistogram.getMaxArea(heights));
        System.out.println(rectangleHistogram.getMaxArea(heights2));
    }

    private int getMaxArea(int heights[]) {
        // Create an empty stack. The stack holds indexes of heights[] array
        // The bars stored in stack are always in increasing order of their
        // heights.
        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;
        int topIndex;  // To store top of stack
        int areaWithTop; // To store area with top bar as the smallest bar

        int i = 0;
        while (i < heights.length) {
            // If this bar is higher than the bar on top stack, push it to stack
            if (stack.empty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i);
                i++;
                // If this bar is lower than top of stack, then calculate area of rectangle
                // with stack top as the smallest (or minimum height) bar. 'i' is
                // 'right index' for the top and element before top in stack is 'left index'
            } else {
                topIndex = stack.pop();
                // Calculate the area with heights[topIndex] stack as smallest bar
                areaWithTop = heights[topIndex] * (stack.empty() ? i : i - stack.peek() - 1);
                // update max area, if needed
                maxArea = Math.max(maxArea, areaWithTop);
            }
        }

        // Now pop the remaining bars from stack and calculate area with every
        // popped bar as the smallest bar
        while (!stack.empty()) {
            topIndex = stack.pop();
            areaWithTop = heights[topIndex] * (stack.empty() ? i : i - stack.peek() - 1);
            maxArea = Math.max(maxArea, areaWithTop);
        }
        return maxArea;
    }
}
