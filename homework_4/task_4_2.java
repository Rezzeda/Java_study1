package homework_4;

import java.util.LinkedList;
import java.util.List;

/**
 Реализуйте очередь с помощью LinkedList со следующими методами:
enqueue() - помещает элемент в конец очереди, dequeue() - 
возвращает первый элемент из очереди и удаляет его, 
first() - возвращает первый элемент из очереди, не удаляя.
 */

public class task_4_2 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
             list.add("Москва");
             list.add("Санкт-Петербург");  
             list.add("Казань");
             list.add("Ижевск");       
        System.out.println(list.toString());

        enqueue(list, "Новосибирск");
        System.out.println(dequeue(list));
        System.out.println(list);
        System.out.println(first(list));
        System.out.println(list);
    }

    private static void enqueue (List<String> list, String element) { 
        list.add(element);
        System.out.println(list);
    }

    private static String dequeue (List<String> list) {
        String element = list.get(0);
        list.remove(0);
        return element;
    }

    private static String first(List<String> list) {
        String element = list.get(0);
        return element;
    }
    
}
