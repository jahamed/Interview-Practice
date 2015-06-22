import java.util.Scanner;

/**
 * Created by jahamed on 6/22/15.
 */
public class FizzBuzz {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        for(int i=1; i<=num; i++){
            if(i % 15 == 0){
                System.out.println("FizzBuzz");
            }else if(i % 3 == 0){
                System.out.println("Fizz");
            }else if(i % 5 == 0){
                System.out.println("Buzz");
            }else{
                System.out.println(i);
            }
        }
    }
}
