package HomeWork4.Task2;


public class MainClass {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Testov", "1234");
        phoneBook.add("Testov2", "2345");
        phoneBook.add("Testov3", "3456");
        phoneBook.add("Testov4", "4567");
        phoneBook.add("Testov", "5678");
        phoneBook.add("Testov", "6789");

        System.out.println(phoneBook.get("Testov"));

    }
}
