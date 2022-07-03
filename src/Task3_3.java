public class Task3_3 {
    public static void main(String args[]) {
        // Написать программу, показывающую последовательность 
        // действий для игры “Ханойская башня”
        move(5, 1, 3, 2);
    }

    public static void move(int n, int fromAxis, int toAxis, int auxAxis) {
        if (n == 0) {
            return;
        }
        // Перемещаем все элементы с from на дополнительную ось
        move(n - 1, fromAxis, auxAxis, toAxis);
        // Перемещаем один элемент
        System.out.printf("Перемещаем элемент %s с оси %s на ось %s", n, fromAxis, toAxis);
        System.out.println();
        // Перемещаем все элементы обратно с дополнительной оси на ось to
        move(n - 1, auxAxis, toAxis, fromAxis);
    }
}