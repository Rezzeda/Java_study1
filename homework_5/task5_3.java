package Homework_5;

import java.util.Arrays;
import java.util.Random;

/**
 * Реализовать алгоритм пирамидальной сортировки (HeapSort)
 */


public class task5_3 {

    static Random random = new Random();

    public static void main(String[] args) {
        int[] randomNumbers = getRandomArray(10, 0, 100);
        System.out.println(Arrays.toString(randomNumbers));
        heapSort(randomNumbers);
        System.out.println(Arrays.toString(randomNumbers));
    }

     // создаем массив и заполняем его рандомными числами
    private static int[] getRandomArray(int size, int min, int max){
        int[] arr = new int[size];
        int index = 0;
        while (index < size) {
            arr[index] = random.nextInt(min, max);
            index = index + 1;
        }
        return arr;
    }

    public static void heapSort(int arr[]){
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) // Построение кучи (перегруппируем массив)
            heapify(arr, n, i);   
        for (int i=n-1; i>=0; i--)  // Один за другим извлекаем элементы из кучи
        {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0); // Вызываем процедуру heapify на уменьшенной куче
        }
    }
    private static void heapify(int arr[], int n, int index)
    {
        int largest = index; // Инициализируем наибольший элемент как корень
        int left = 2 * index + 1; 
        int right = 2 * index + 2;

           // Если левый дочерний элемент больше корня
        if (left < n && arr[left] > arr[largest])
            largest = left;

          // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (right < n && arr[right] > arr[largest])
            largest = right;
       // Если самый большой элемент не корень
        if (largest != index)
        {
            int swap = arr[index];
            arr[index] = arr[largest];
            arr[largest] = swap;

          // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(arr, n, largest);
        }
    }

}
