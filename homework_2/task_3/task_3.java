package homework_2.task_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
    В файле содержится строка с данными:
    [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"}, {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
    {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
    Напишите метод, который разберёт её на составные части и, используя StringBuilder создаст массив строк такого вида:
    Студент Иванов получил 5 по предмету Математика.
    Студент Петрова получил 4 по предмету Информатика.
    Студент Краснов получил 5 по предмету Физика.
*/

public class task_3 {
    public static void main(String[] args) {
        String pathProject = System.getProperty("user.dir");
        String pathFile = pathProject.concat("/homework_2/task_3/file_3_3.txt");
        String line = readFile(pathFile);
        System.out.println(line);

        String[] resultArrayOfString = getResultString(getDataFromString(line)).split(",");
        for (String el : resultArrayOfString){
            System.out.println(el);
        }
    }

    // считываем файл
    static String readFile(String fileName) {
        String data = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            data = br.readLine();
            br.close();
        } catch (IOException ex){
            System.out.println("Error!");
        } 
        return data;
    }

    // убираем лишние знаки и достаем нужные данные
    static String[] getArray(String line){
        int index = 0;
        line = line.substring(1, line.length()-1);
        String[] pairs = line.split(",");
        int length = pairs.length;
        String[] fieldName = new String[length];
        for (String el : pairs){
            int indexOfColon = el.indexOf(':');
            fieldName[index] = el.substring(indexOfColon+2, el.length()-1);
            index++;
        } 
        return fieldName;
    }


    //убираем лишние знаки и достаем только значения
    static String getDataFromString(String line){
        StringBuilder sb = new StringBuilder();
        line = line.substring(1, line.length()-1);
        String[] pairs = line.split(", ");
        for (String el : pairs){
            sb.append(String.join(",", getArray(el)));
            sb.append(",");
        }
        return sb.toString();
    }
    

    // подставляем и формируем нужную строку
    static String getResultString(String str){
        StringBuilder result = new StringBuilder();
        String[] array = str.split(",");
        for (int i = 0; i <array.length ; i+=3) {
            result.append("Студент ");
            result.append(array[i]);
            result.append(" получил ");
            result.append(array[i+1]);
            result.append(" по предмету ");
            result.append(array[i+2]);
            result.append(".");
            result.append(",");
        }
        return result.toString();
    }
}