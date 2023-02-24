package homework_6;

import java.util.*;

public class main {
    private static Scanner input = new Scanner(System.in);
    private static Scanner line = new Scanner(System.in);
    public static Notebook requiredNotebook = new Notebook(null, null, null, null);

    public static void main(String[] args) {
        List<Notebook> notebooks = new ArrayList<>();
        getNotebooks(notebooks);
        findNotebook(notebooks);
    }

    private static void getNotebooks(List<Notebook> notebooks) {
        Notebook notebook = new Notebook("Honor", 8, "Windows", "Gray");
        notebooks.add(notebook);
        
        notebook = new Notebook("Apple MacBook Air 13", 8, "MacOS", "Space Gray");
        notebooks.add(notebook);

        notebook = new Notebook("Lenovo ThinkPad", 32, "Windows", "Space Gray");
        notebooks.add(notebook);

        notebook = new Notebook("Apple MacBook Pro 16", 16, "MacOS", "Space Gray");
        notebooks.add(notebook);

        notebook = new Notebook("MSI Creator Z17", 32, "Windows", "Gray");
        notebooks.add(notebook);

        notebook = new Notebook("Dell Vostro", 16, "Linux", "Black");
        notebooks.add(notebook);
    }
        
    private static void findNotebook(List<Notebook> notebooks) {
        int action = getAction("Искать ноутбук по:\n1 - Название" 
        + "\n2 - RAM(ОЗУ - опретивная память)\n3 - Операционная система\n4 - Цвет\n");

        if (action == 1){
            String finder = finder("Введите название: ");
            int count = 0;
            for (Notebook notebook : notebooks) {
                if (notebook.getBrandName().equals(finder)) {
                    System.out.println("*** Найден ***\n" + notebook);
                    count +=1;
                }
            }
            if (count == 0)
                System.out.println("К сожалению, такого товара нет.");

        }
    
        if (action == 2){
            String finder = finder("Введите кол-во опретивной памяти в Гб: ");
            int count = 0;
            for (Notebook notebook : notebooks) {
                if (notebook.getRAM() == Integer.valueOf(finder)) {
                    System.out.println("*** Найден ***\n" + notebook);
                    count +=1;
                }
            }
            if (count == 0)
            System.out.println("К сожалению, такого товара нет.");
        }

        if (action == 3){
            String finder = finder("Введите название OS: Windows/MacOS/Linux: ");
            int count = 0;
            for (Notebook notebook : notebooks) {
                if (notebook.getOS().equals(finder)) {
                    System.out.println("*** Найден ***\n" + notebook);
                    count +=1;
                }
            }
            if (count == 0)
                System.out.println("К сожалению, такого товара нет.");

        }
        if (action == 4){
            String finder = finder("Введите название: ");
            int count = 0;
            for (Notebook notebook : notebooks) {
                if (notebook.getColor().equals(finder)) {
                    System.out.println("*** Найден ***\n" + notebook);
                    count +=1;
                }
            }
            if (count == 0)
                System.out.println("К сожалению, такого товара нет.");
        }
    }
    
    private static int getAction(String text) {
        System.out.print(text);
        return input.nextInt();
    }
    private static String finder(String text) {
        System.out.print(text);
        return line.nextLine();
    }
}

