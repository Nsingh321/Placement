package ArraysPractise;

public class avgSalaryExcludingMaxAndMinSalary {

    public static void main(String[] args) {
        avgSalaryExcludingMaxAndMinSalary obj = new avgSalaryExcludingMaxAndMinSalary();


        //int a[] = { 4000,3000,1000,2000};
        int a[] = {1000,2000,3000};
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0;i<a.length;i++){
           max = Math.max(a[i],max);
            min = Math.min(a[i],min);
        }

        System.out.println(max);
        System.out.println(min);

        int sum = 0;
        double count = 0;
        for(int j = 0;j<a.length;j++){
            if(a[j] !=max && a[j] !=min){
                count++;
                sum = sum+a[j];
            }
        }
        System.out.println(sum/count);

    }
}
