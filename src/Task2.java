
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("Введите N=");
        Scanner iScanner = new Scanner(System.in);
        int n = iScanner.nextInt();
        iScanner.close();

        int nn = n;
        int sum = 0;
        while (nn > 0) {
            int lastDigit = nn % 10;
            sum = sum + lastDigit;
            nn = nn / 10;
        }
        System.out.printf("Число которое делится без остатка на сумму цифр числа %d равно %d", n, sum);
    }
}