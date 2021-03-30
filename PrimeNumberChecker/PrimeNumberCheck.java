import java.util.Scanner;

public class PrimeNumberCheck {

    public static void main(String args[]) {
        Scanner scnr = new Scanner(System.in);
        int number = Integer.MAX_VALUE;
        System.out.println("Enter number to check if prime or not ");
        while (number != 0) {
            number = scnr.nextInt();
            System.out.printf("Is %d a Prime Number? %s %s  %n", number,
                    isPrime(number), isPrimeOrNot(number));
        }
    }


    public static boolean isPrime(int number) {
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 2; i < sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }



    
    public static String isPrimeOrNot(int num) {
        if (num < 0) {
            return "NOT VALID";
        }
        if (num == 0 || num == 1) {
            return "NOT Prime";
        }
        if (num == 2 || num == 3) {
            return "Prime Number";
        }
        if ((num * num - 1) % 24 == 0) {
            return "Prime";
        } else {
            return "NOT Prime";
        }
    }
}