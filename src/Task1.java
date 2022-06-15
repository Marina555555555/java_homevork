import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        System.out.println("Введите N=");
        Scanner iScanner = new Scanner(System.in);
        int n = iScanner.nextInt();
        iScanner.close();

        int t = n * (n + 1) / 2;
        System.out.printf("%d-e треугольное число=%d", n, t);
    }
}