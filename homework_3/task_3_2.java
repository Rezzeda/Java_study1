package homework_3;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

/**
 * Пусть дан произвольный список целых чисел, удалить из него чётные числа
 */

public class task_3_2 {

    static Random random = new Random();

    public static void main(String[] args) {
        List numbers = new ArrayList<Integer>();
        getList(numbers);
        System.out.println(numbers);
        deleteEvenNumbers(numbers);
        System.out.println(numbers);
    }

    //Создаем список рандомных чисел
    public static List getList(List numbers) {
        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(0, 100));
        } return numbers;
    }
    
    // Удаляем четные числа
    public static List deleteEvenNumbers(List list) {
        for (int i = 0; i < list.size(); i++) {
            if ((Integer)list.get(i)%2==0) {
                list.remove(i);
                i--;
            }    
        } return list;
    }
}
