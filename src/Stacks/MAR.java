package Stacks;

//Maximum area rectangle in binary matrix


import java.util.Stack;

public class MAR {

    static class Pair {

        int element;
        int index;

        public Pair(int element, int index) {
            this.element = element;
            this.index = index;
        }

    }

    static int MAH(int a[]) {
        Stack<MAH.Pair> stack = new Stack<>();
        int n = a.length;
        int nsrIndex[] = new int[n];
        int pseudoIndex = n;

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek().element >= a[i]) {
                stack.pop();
            }
            if (i < n) {
                if (!stack.isEmpty()) {
                    nsrIndex[i] = stack.peek().index;
                } else {
                    nsrIndex[i] = pseudoIndex;
                }
            }
//            push the current element onto the stack
            stack.push(new MAH.Pair(a[i], i));
        }

        // System.out.println("NSR -> "+ Arrays.toString(nsrIndex));

        //re-initialize stack to find next smaller to left element's index
        stack = new Stack<>();
        int nslIndex[] = new int[a.length];
        pseudoIndex = -1;

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && stack.peek().element >= a[i]) {
                stack.pop();
            }
            if (i < n) {
                if (!stack.isEmpty()) {
                    nslIndex[i] = stack.peek().index;
                } else {
                    nslIndex[i] = pseudoIndex;
                }
            }
//            push the current element onto the stack
            stack.push(new MAH.Pair(a[i], i));
        }
        //System.out.println("NSL ->"+Arrays.toString(nslIndex));

        //width[i] = nsrIndex[i] - nslIndex[i]
        int width[] = new int[n];
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            width[i] = nsrIndex[i] - nslIndex[i] - 1;
            int area = a[i] * width[i]; //area = a[i] * width[i]
            maxArea = Math.max(area, maxArea);
        }
//        System.out.println("Width ->"+Arrays.toString(width));
//        System.out.println("Max Area "+maxArea);
        return maxArea;
    }

    private static int MAR(int matrix[][], int n, int m) {

//        List<Integer> list = new ArrayList<>();

        int b[] = new int[m];
        for (int j = 0; j < m; j++) {

            b[j] = matrix[0][j];
        }
        int max = MAH(b);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    b[j] = 0;
                } else {
                    b[j] = b[j] + matrix[i][j];
                }
            }
            max = Math.max(max, MAH(b));
        }
        return max;

    }

    public static void main(String[] args) {
        int matrix[][] =
                {{0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0}};

        int n = matrix.length;//rows
        int m = matrix[0].length;//cols
        int result = MAR(matrix, n, m);
        System.out.println(result);


    }
}
