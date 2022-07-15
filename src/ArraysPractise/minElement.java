package ArraysPractise;

import java.util.Arrays;

public class minElement {

    public static void main(String[] args) {
        int arr[] = {2,5,1,3,0};

        Arrays.sort(arr);
        System.out.println(arr[0]);//element at 0th index is the shortest
    }
}
