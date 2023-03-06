import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task1Dictionary {

  public static Map<String, String> readDictionaryFromFile() throws IOException {
    Map<String, String> dictionary = new HashMap<>();

    try {
      BufferedReader read = new BufferedReader(new FileReader("res/dict.txt"));
      int num = Integer.parseInt(read.readLine());

      for (int i = 0; i < num; ++i) {
        String line = read.readLine();

        int position = line.indexOf(":");
        String key = line.substring(0, position).toLowerCase();
        String result = line.substring(position + 2);

        dictionary.put(key, result);
      }
      read.close();

    } catch (FileNotFoundException e) {
      System.err.println("Problems with file reading" + e.getMessage());
    } catch (NumberFormatException e) {
      System.err.println("Incorrect input data" + e.getMessage());
    } catch (StringIndexOutOfBoundsException e) {
      System.err.println("Wrong information in file txt" + e.getMessage());
    }

    return dictionary;
  }

  public static List<String> readSearchWords() throws IOException {
    List<String> question = new ArrayList<>();

    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());

      for (int i = 0; i < n; ++i) {
        String userQuestion = br.readLine().toLowerCase();
        question.add(userQuestion);
      }
    } catch (NumberFormatException e) {
      System.err.println("Incorrect search request" + e.getMessage());
    }

    return question;
  }

  public static void printDefinitions(List<String> question, Map<String, String> dictionary) {
    for (String q : question) {
      if (dictionary.containsKey(q)) {
        System.out.println(dictionary.get(q));
      } else {
        System.out.println("Не найдено");
      }
    }
  }

  public static void main(String[] args) throws IOException {

    Map<String, String> dictionary = readDictionaryFromFile();
    List<String> question = readSearchWords();
    printDefinitions(question, dictionary);

  }
}

