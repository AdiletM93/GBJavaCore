package HomeWork4.Task2;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

    public void add(String surname, String phoneNumber) {
        ArrayList<String> surnamePhone = phoneBook.getOrDefault(surname, new ArrayList<>());
        surnamePhone.add(phoneNumber);
        phoneBook.put(surname, surnamePhone);
    }

    public ArrayList<String> get(String surname) {
        return phoneBook.get(surname);
    }
}
