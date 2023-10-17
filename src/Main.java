import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String romanNumber= sc.next();

        //function call to convert roman number to integer
        int integer= convertToInteger(romanNumber);
        if(integer!=-1) {
            System.out.println(romanNumber + " " + "->" + " " + integer);
        }else{
            System.out.println("This is not a valid Roman number, Please enter valid number.");
        }
    }
    public static int values(char ch)
    {
        //values mapped with the integer
        if (ch == 'I')
            return 1;
        if (ch == 'V')
            return 5;
        if (ch == 'X')
            return 10;
        if (ch == 'L')
            return 50;
        if (ch == 'C')
            return 100;
        if (ch == 'D')
            return 500;
        if (ch == 'M')
            return 1000;
        return -1;
    }
    public static int convertToInteger(String romanNumber){
            int ans = 0, n=romanNumber.length();

            for (int i = 0; i < n; i++) {

                //getting mapped value of current char
                int curr = values(romanNumber.charAt(i));

                if (i + 1 < n) {
                    //getting next char if lie in a valid index
                    int next = values(romanNumber.charAt(i + 1));

                    //comparing values of both char
                    if (curr >= next) {
                        ans += curr;
                    }
                    else {
                        ans = ans + next - curr;
                        i++;
                    }
                }
                else {
                    ans = ans + curr;
                }
            }
            return ans;
    }
}