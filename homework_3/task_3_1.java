package homework_3;

import java.util.Random;
import java.util.Arrays;

/**
 * Реализовать алгоритм сортировки слиянием
 */

public class task_3_1 {

    static Random random = new Random();

    public static void main(String[] args) {
       
        int [] randomNumbers = getRandomArray(10, 0, 100);
        System.out.println(Arrays.toString(randomNumbers));
        randomNumbers = mergeSort(randomNumbers);
        System.out.println(Arrays.toString(randomNumbers));
    }

     // создаем массив и заполняем его рандомными числами
    public static int[] getRandomArray(int size, int min, int max){
        int[] arr = new int[size];
        int index = 0;
        while (index < size) {
            arr[index] = random.nextInt(min, max);
            index = index + 1;
        }
        return arr;
    }

    // делим исходный массив пополам
    public static int[] mergeSort(int[] array) {
        if (array.length <= 1) return array; // условие выхода из рекурсии: пока размер массива не станет равен 1
        //Индекс источника, с которого начнем (0), индекс источника, по достижению которого копирование прекратится* (src.length / 2)
        int[] left = Arrays.copyOfRange(array, 0, array.length / 2);
        int[] right = Arrays.copyOfRange(array, left.length, array.length);
        return merge(mergeSort(left), mergeSort(right));
        }
    
    // создадим новый массив result, в который будем помещать элементы массивов left и right по возрастанию.
    private static int[] merge(int[] left, int[] right) {
        int resIn = 0, leftIn = 0, rightIn = 0; //счетчики для индекса каждого из массивов
        int[] result = new int[left.length + right.length];
    
        //left и right могут быть разного размера, будем записывать значения в result, пока не дойдем до конца хотя бы одного из них
        while (leftIn < left.length && rightIn < right.length)
            if (left[leftIn] < right[rightIn])
                result[resIn++] = left[leftIn++];
            else result[resIn++] = right[rightIn++];
    
        // Если в цикле мы дошли до конца одного массива, но не дошли до конца второго, 
        //оставшиеся элементы также потребуется добавить к результирующему массиву
        while (resIn < result.length)
            if (leftIn != left.length)
                result[resIn++] = left[leftIn++];
            else result[resIn++] = right[rightIn++];
    
        return result;
    }
}
