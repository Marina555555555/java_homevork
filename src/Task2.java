import java.util.Scanner;

public class Task2 {
    public static void main(String args[]) {
        System.out.println("Введите строку");

        Scanner iScanner = new Scanner(System.in);
        String s = iScanner.nextLine();
        iScanner.close();

        String res = "";

        // устанавливаем счетчик в 1, потому что нулевой символ уже встречается один раз
        int count = 1;
         
        // abba -> a1b2a1
        // 0123

        // начинаем с единицы потому что будем сравнивать с предыдущим
        for (int i = 1; i < s.length(); i++) {
            // сравниваем текущий символ с предыдущим
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                // добавляем к строке предыдущий символ и значение счетчика
                res += s.charAt(i - 1) + String.valueOf(count);
                // сбрасываем счетчик в начальное состояние
                // 1 потому что новый символ уже встретился один раз
                count = 1;
            }
        }

        // добавляем информацию о последней группе символов
        res += s.charAt(s.length() - 1) + String.valueOf(count);

        System.out.println(res);
    }


}