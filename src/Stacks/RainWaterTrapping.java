package Stacks;

import java.util.Arrays;

public class RainWaterTrapping {

    private static int rainWaterTrapping(int a[],int size){

        int maxL[] = new int[size];
        int maxR[] = new int[size];

        //for finding the maximum element in left array at any position
        maxL[0] = a[0];
        for(int i=1;i<size;i++){
            maxL[i] = Math.max(maxL[i-1],a[i]);
        }
        System.out.println(Arrays.toString(maxL));

        //for finding the maximum element in right array at any position
        maxR[size-1] = a[size-1];
        for(int i = size-2;i>=0;i--){
            maxR[i] = Math.max(maxR[i+1] , a[i]);
        }
        System.out.println(Arrays.toString(maxR));

        //finding the water level on every building
        int water[] = new int[size];
        for(int i=0;i<size;i++){
            water[i] = Math.min(maxL[i] , maxR[i]) - a[i];
        }
        System.out.println(Arrays.toString(water));

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum = sum + water[i];
        }
        return sum;

    }

    public static void main(String[] args) {

        int a[] = {3,0,0,2,0,4};
        int size = a.length;

        int result = rainWaterTrapping(a,size);
        System.out.println("result "+result);

    }
}
