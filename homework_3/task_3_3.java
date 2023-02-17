package homework_3;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Задан целочисленный список ArrayList. 
 * Найти минимальное, максимальное и среднее арифметическое этого списка.
 */

public class task_3_3 {
    static Random random = new Random();
    public static void main(String[] args) {
        List numbers = new ArrayList<Integer>();
        getList(numbers);
        System.out.println(numbers);
        // System.out.println(Collections.max(numbers));
        // System.out.println(Collections.min(numbers));
        System.out.println("минимальное число: " + findMin(numbers));
        System.out.println("максимальное число: " + findMax(numbers));
        System.out.println("Среднее арифметическое списка: " + findAverage(numbers));
    }

    //Создаем список рандомных чисел
    public static List getList(List numbers) {
        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(0, 10));
        } return numbers;
    }
    // Поиск максимального значения
    public static Integer findMax (List list) {
        Integer max = (Integer)list.get(0);
        for (int i = 0; i<list.size(); i++) {
            if((Integer)list.get(i) > max) max = (Integer)list.get(i);
        }return max;
    }
    // Поиск минимального значения
    public static int findMin (List list) {
        Integer min = (Integer)list.get(0);
        for (int i = 0; i<list.size(); i++) {
            if((Integer)list.get(i) < min) min = (Integer)list.get(i);
        }return min;
    }

    // Вычисляем среднее арифметическое
    public static double findAverage (List list) {
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += (Integer) list.get(i);
        }
        double average = sum / list.size();
        return average;
    }

}
