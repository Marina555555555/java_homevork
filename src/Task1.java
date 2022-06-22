import java.util.Scanner;

public class Task1 {
    public static void main(String args[]) {
        System.out.println("Введите строку");

        Scanner iScanner = new Scanner(System.in);
        String s = iScanner.nextLine();
        iScanner.close();
        boolean isPalindrome = new StringBuilder(s).reverse().toString().equals(s); 
        if (isPalindrome) {
            System.out.printf("Строка %s является палиндромом", s);
        } else {
            System.out.printf("Строка %s не является палиндромом", s);
        }
        System.out.println();
    }
}