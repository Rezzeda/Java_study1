package homework_2.task_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * В файле содержится строка с исходными данными в такой форме:
{"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";
Для разбора строки используйте String.split. Сформируйте новую строку, используя StringBuilder. Значения null не включаются в запрос.
 */
public class task_1 {
public static void main(String[] args) {
    String pathProject = System.getProperty("user.dir");
    String pathFile = pathProject.concat("/homework_2/task_1/file_1.txt");
    String line = readFile(pathFile);
    //System.out.println(line);

    String[] temp = getArray(line);
    String name = temp[0];
    String country = temp[1];
    String city = temp[2];

    System.out.println(getSQLLine(name,country,city));
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
    }return fieldName;
    }


// подставляем и формируем нужную строку
static String getSQLLine(String name, String country, String city){
        StringBuilder result = new StringBuilder();
        
        result.append("SELECT * FROM students WHERE name = \"");
        result.append(name);
        
        result.append("\" AND country = \"");
        result.append(country);
        
        result.append("\" AND city = \"");
        result.append(city);
        result.append("\";");
        
        return result.toString();
        }
    
}