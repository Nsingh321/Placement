package Recursion.Intermediate;

public class countSubseqWithSumK {

    static int countSubseq(int index , int s,int sum,int arr[],int n){

        //base case
        if(index == n){
            if(s == sum){
                return 1;
            }
            else return 0;
        }

        s = s+arr[index];//add current element to the 's'
        int l = countSubseq(index+1,s,sum,arr,n);//make a call for the next index and store in 'l'
        s = s-arr[index];//remove the added element from the 's'
        int r = countSubseq(index+1,s,sum,arr,n);//make a call for the next index and store in 'r'

        return l+r;//add all function call and return
    }

    public static void main(String[] args) {

        int arr[] = {1,2,1};
        int n = 3;
        int sum =2;

        System.out.println(countSubseq(0,0,sum,arr,n));

    }
}
