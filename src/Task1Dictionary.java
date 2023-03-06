
//добавляем файлы, если они указаны в задаче
//разбиваем задачу на методы
//добавляем try..catch

//    Формат входных данных
//    Файл dict.txt
//    В первой строке задано одно целое число n — количество слов в словаре.
//
//    В следующих n строках записаны слова и их определения,
//    разделенные двоеточием и символом пробела.
//
//    Ввод с клавиатуры
//    В первой строке записано целое число m — количество поисковых слов,
//    чье определение нужно вывести.
//
//    В следующих m строках записаны сами слова, по одному на строке.
//
//    Формат выходных данных
//    Для каждого слова, независимо от регистра символов, если оно присутствует в словаре,
//    необходимо вывести на экран его определение.
//
//    Если слова в словаре нет, программа должна вывести "Не найдено", без кавычек.
//
//    Примечание 1
//    Мини-словарь для начинающих разработчиков можно посмотреть тут.
//
//    Примечание 2
//    Гарантируется, что в определяемом слове или фразе отсутствует двоеточие (:),
//    следом за которым идёт пробел.
//
//    Пример входных данных
//    5
//Змея: язык программирования Python
//Баг: от англ. bug — жучок, клоп, ошибка в программе
//Конфа: конференция
//Костыль: код, который нужен, чтобы исправить несовершенство ранее написанного кода
//Бета: бета-версия, приложение на стадии публичного тестирования
//////    3
//Змея
//Жаба
//костыль

//    Пример выходных данных
//    язык программирования Python
//    Не найдено
//    код, который нужен, чтобы исправить несовершенство ранее написанного кода

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task1Dictionary {
  public static void main(String[] args) throws IOException {
    BufferedReader read = new BufferedReader(new FileReader("res/dict.txt"));

    //read income data and add it to dictionary
    int num = Integer.parseInt(read.readLine());
    Map<String, String> dictionary = new HashMap<>(); // create dictionary before start to read data

    for (int i = 0; i < num; ++i) { // check all line one by one
      String line = read.readLine(); // read first line

      int position = line.indexOf(":"); // find position of colon
      String key = line.substring(0, position).toLowerCase(); // everything before column is key
      String result = line.substring(position + 2); // all the next - value

      dictionary.put(key, result);
    }
    read.close();

    //read word for search and add it to List
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    List<String> question = new ArrayList<>();

    for (int i = 0; i < n; ++i) {
      String userQuestion = br.readLine().toLowerCase();
      question.add(userQuestion);
    }

    //method for output data
    for (String q : question) {
      if (dictionary.containsKey(q)) {
        System.out.println(dictionary.get(q));
      } else {
        System.out.println("Не найдено");
      }
    }
  }
}
