package homework_4;

import java.util.LinkedList;
import java.util.List;

/**
 Пусть дан LinkedList с несколькими элементами. 
 Реализуйте метод, который вернет “перевернутый” список.
 */

public class task_4_1 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
             list.add("Москва");
             list.add("Санкт-Петербург");  
             list.add("Казань");
             list.add("Ижевск");      
      
        System.out.println(list.toString());
        reverseList(list);
    }
    private static void reverseList(List<String> list) {
        LinkedList<String> newList = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            newList.add(list.get((list.size()-1)-i));
        }
        System.out.println(newList.toString());
    }
}