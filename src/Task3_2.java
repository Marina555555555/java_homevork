import java.util.Scanner;

public class Task3_2 {
    public static void main(String args[]) {
        // Написать метод, который проверяет валидность логина и пароля 
        // (где нибудь в переменных сохраните) и при помощи конструкции 
        // try-catch рекурсивно принимайте данные (нужно ограничить 
        // колиичество попыток до 6 и после 3 попытки должно быть сообщение,
        // мол вы привысили количество попыток, немного пододождите 
        // тут можете поток заслипить на некоторое время. 
        // А когда попытки кончатся - выйти)
        checkLoginAndPassword(1);
    }

    public static void checkLoginAndPassword(int tries) {
        String expectedLogin = "login";
        String expectedPassword = "password";
    
        Scanner iScanner = new Scanner(System.in);
    
        System.out.print("Введите логин: ");
        String login = iScanner.nextLine();

        System.out.print("Введите пароль: ");
        String password = iScanner.nextLine();

        try {
            if (login.equals(expectedLogin) && password.equals(expectedPassword)) {
                System.out.println("Добро пожаловать.");
            } else {
                System.out.println("Неверный логин или пароль.");
                if (tries == 3) {
                    System.out.println("Вы сделали три неверных попытки, подождите.");

                    Thread.sleep(3000);
                    checkLoginAndPassword(tries + 1);
                } else if (tries < 6) {
                    checkLoginAndPassword(tries + 1);
                } else {
                    System.out.println("Вы исчерпали все шесть попыток.");
                }
            } 
        } catch (Exception e) {
            
        }
        iScanner.close();
    }
 
}