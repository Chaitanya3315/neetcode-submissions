class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] nextSmall = getNext(heights);
        int[] prevSmall = getPrev(heights);

        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int width = nextSmall[i] - prevSmall[i] - 1;
            int area = width * heights[i];
            max = Math.max(max, area);
        }
        return max;
    }

    public int[] getNext(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return res;
    }

    public int[] getPrev(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return res;
    }
}
