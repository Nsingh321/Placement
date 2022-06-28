package string;


public class validPalindrome {

    private static boolean checkPalin(String s){


    int i=0; int j= s.length()-1;
    while(i<j){
        //if character is not a digit or letter(special character) or is a white space then skip it
        if(!Character.isLetterOrDigit(s.charAt(i)) || s.charAt(i) ==' '){
            i++;
        }else if(!Character.isLetterOrDigit(s.charAt(j)) || s.charAt(j) ==' '){
            j--;

            //character is a digit or letter(special character) or is a white space then check it
        }else if(Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))){
            i++; j--;
        }else{
            return false;
        }
    }

    return true;

}



    public static void main(String[] args) {


        String s = "aabb";
        System.out.println(checkPalin(s));

    }
}
