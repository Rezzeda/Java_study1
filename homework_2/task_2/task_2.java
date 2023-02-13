package homework_2.task_2;

import java.io.IOException;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/* Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите
 в лог-файл.
* */

public class task_2 {
    private static Random random = new Random();

    public  static void main(String[] args){

        int[] array = getRandomArray(5, 0, 10);
        for (int element : array) System.out.printf("%d ", element);
        getLog(array);
        for (int element : array) System.out.printf("%d ", element);
    }
    static void getLog(int[] array){
        try {
            Logger logger = Logger.getLogger(task_2.class.getName());
            String pathProject = System.getProperty("user.dir");
            String pathFile = pathProject.concat("/homework_2/task_2/log.txt");
            FileHandler fh = new FileHandler(pathFile);
            logger.addHandler(fh);
            logger.setLevel(Level.INFO);

            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);

            int len =  array.length;
            int el = 0;
            String str = "";
            for (int i = 0; i < len-1; i++) {
                for (int j = i + 1; j < len; j++) {
                    if (array[i] > array[j]) {
                        el = array[i];
                        array[i] = array[j];
                        array[j] = el;
                        str = "Элемент " + el + " перемещен на позицию " + j;
                        logger.info(str);
                    }
                }
                str = "";
            }
            } catch (IOException ex){
                System.out.println("Error!");
            }
        }

    static int[] getRandomArray(int size, int min, int max){
        int[] arr = new int[size];
        int index = 0;
        while (index < size) {
            arr[index] = random.nextInt(min, max);
            index = index + 1;
        }
        return arr;
    }
}