package HomeWork4.Task1;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>(Arrays.asList("Кот", "Собака", "Кот", "Кот", "Робот",
                "Слово", "Робот", "Машина", "Робот", "Человек", "Робот"));

        System.out.println(words);

        HashSet<String> uniqueWords = new HashSet<>(words);

        System.out.println(uniqueWords);

        for (String key : uniqueWords) {
            System.out.print(key + " - " + Collections.frequency(words, key) + ", ");
        }
    }
}
