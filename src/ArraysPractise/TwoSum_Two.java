package ArraysPractise;

//DONE by Two Pointers
import java.util.Arrays;

public class TwoSum_Two {


    public static void main(String[] args) {
//        int numbers[] = {2,7,11,15}, target = 9;
//        int numbers[] = {2,3,4}, target = 6;
        int numbers[] = {-1,0}, target = -1;
        int n=numbers.length-1;
        int b[] = new int[2];
        boolean found = false;



        int i = 0;
        int j = numbers.length-1;
        while(i<j){
            if(numbers[i]+numbers[j] == target){
                found = true;
                b[0] = i+1;
                b[1] = j+1;
                System.out.println(Arrays.toString(b));
                System.out.println(i+" "+j);
                break;
            }
            else if(numbers[i]+numbers[j]>target){
                j--;
            }
            else if(numbers[i]+numbers[j]<target){
                i++;
            }
        }
        System.out.println("not found");

    }




}
