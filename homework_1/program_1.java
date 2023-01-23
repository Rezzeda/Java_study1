package homework_1;
import java.util.*;

public class program_2 {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int n = getNumberByUser("Введите номер числа в последовательности треугольных чисел: ");
        System.out.printf("Треугольное число: %d", getTriangleNumber(n));
    }

// Ввод числа - номера числа в последовательности треугольных чисел
static int getNumberByUser(String text) {
    System.out.print(text);
    return input.nextInt();
  }
// Получение и вывод необходимого числа
static int getTriangleNumber(int n) {
    int number = (n*(n+1))/2;
    return number;
  }
}