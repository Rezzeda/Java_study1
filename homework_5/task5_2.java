package Homework_5;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Пусть дан список сотрудников: Иван, Пётр, Антон и так далее. 
 * Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. 
 * Отсортировать по убыванию популярности.
 */

public class task5_2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(
            "Иван", "Петр", "Антон", "Василий", "Петр",
            "Антон", "Петр", "Иван", "Геннадий", "Антон",
            "Иван", "Иван", "Иван", "Анатолий","Василий", "Антон", "Геннадий");
        // собираем элементы листа в карту, k ключ - строка, v значение - число, количество вхождений, суммируем количество вхождений
        Map<String, Integer> frequency = list.stream().collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
    
    // Выводим значение по ключу
    //System.out.println("Иван: " + frequency.get("Иван"));
    // Обходим карту и выводим содержимое без сортировки
    //frequency.forEach((k, v) -> System.out.println(k + ": " + v));
    // Сортировка
    frequency.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()) 
    .forEach(System.out::println);
    }
}
