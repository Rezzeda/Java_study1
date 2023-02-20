package Homework_5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Реализуйте структуру телефонной книги с помощью HashMap, 
 * учитывая, что 1 человек может иметь несколько телефонов.
 */

public class task5_1 {

    private static Scanner scanner = new Scanner(System.in);
    private static Scanner inputAction = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, List<String>> phonebook = new HashMap<>();
        getPhonebook(phonebook);
        int action = getAction("Введите:\n1 - для просмотра всех контактов\n2 - для поиска контакта\n3 - для добавления контакта\n4 - для удаления контакта\n ");
        if (action == 1)
            System.out.println(phonebook);
        if (action == 2)
            findContact(phonebook);
        if (action == 3)
            addContact(phonebook);
        if (action == 4)
        deleteContact(phonebook);
    }
    
    private static int getAction(String text) {
            System.out.print(text);
            return inputAction.nextInt();
    }

    private static void getPhonebook(Map<String, List<String>> phonebook) {
        
        phonebook.put("Иванов", Arrays.asList("23435", "6757656"));
        phonebook.put("Петрова", Arrays.asList("364564"));
        phonebook.put("Петров", Arrays.asList("8977463", "6534876"));
        phonebook.put("Сидоров", Arrays.asList("344525"));
    }

    private static void  findContact(Map<String, List<String>> phonebook) {
        System.out.println("Введите фамилию: ");
        String lastName = scanner.nextLine();
            if (phonebook.containsKey(lastName)){
                System.out.println(phonebook.get(lastName));
            }
            else
            System.out.println("Такого контакта нет!");
    }

    private static void addContact(Map<String, List<String>> phonebook) {
        System.out.println("Введите фамилию: ");
        String lastName = scanner.nextLine();
            if (phonebook.containsKey(lastName)){
                System.out.println("Такой контакт уже есть!");
                return;
            }
            else
            System.out.println("Введите номер телефона: ");
            String phoneNumber = scanner.nextLine();
            phonebook.put(lastName, Arrays.asList(phoneNumber));
        System.out.println(phonebook);
    }

    private static void deleteContact(Map<String, List<String>> phonebook) {
        System.out.println("Введите фамилию: ");
        String lastName = scanner.nextLine();
            if (phonebook.containsKey(lastName)){
                phonebook.remove(lastName);
                System.out.println(lastName + " - контакт удален!");
                System.out.println(phonebook);
                return;
            }
            else
            System.out.println("Контакта " + lastName + " нет");
            System.out.println(phonebook);
    }

}
